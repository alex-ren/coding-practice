package org.plaintech.coding;


import java.util.*;
import java.sql.Timestamp;
import java.time.Instant;

class Twitter {
    static class Item {
        static int gCount = 0;
        int count;
        int id;

        public Item(int aId) {
            count = ++gCount;
            id = aId;
        }
    }

    // user -> tweets
    private Map<Integer, List<Item>> userTweets;

    // follower -> followees
    private Map<Integer, Set<Integer>> followings;


    /** Initialize your data structure here. */
    public Twitter() {
        userTweets = new HashMap<>();
        followings = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Date now = new Date();
        System.out.println("Date is " + now);
        System.out.println("Milli is " + now.getTime());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println("Timestamp is " + timestamp);

        Item p = new Item(tweetId);

        List<Item> tweets = userTweets.get(userId);
        if (null == tweets) {
            tweets = new LinkedList<Item>();
            userTweets.put(userId, tweets);
        }

        tweets.add(0, p);
    }

    private List<Item> getOwnTweets(int userId) {
        List<Item> tweets = userTweets.get(userId);

        List<Item> copy = new LinkedList<>();
        if (null != tweets) {
            for (Item p: tweets) {
                copy.add(p);
            }
        }

        return copy;
    }

    // xss not null
    // xs not null
    private void insert(List<List<Item>> xss, List<Item> xs) {
        System.out.println("insert");
        if (xs.isEmpty()) {
            return;
        }

        Item p = xs.get(0);

        ListIterator<List<Item>> iter = xss.listIterator();
        while (iter.hasNext()) {
            List<Item> cur = iter.next();

            if (p.count > cur.get(0).count) {
                iter.previous();
                iter.add(xs);
                return;
            }
        }

        iter.add(xs);
        return;
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        System.out.println("getNewFeed");

        List<List<Item>> tweetslist = new LinkedList<List<Item>>();
        insert(tweetslist, getOwnTweets(userId));

        Set<Integer> followees = followings.get(userId);
        if (null != followees) {
            for (int followee: followees) {
                insert(tweetslist, getOwnTweets(followee));
            }
        }


        List<Integer> res = new LinkedList<>();

        System.out.println("getNewFeed before going to loop");
        for (int i = 0; i < 10; i++) {
            if (tweetslist.isEmpty()) {
                break;
            }

            List<Item> tweets = tweetslist.remove(0);

            if (null != tweets) {
                if (tweets.isEmpty()) {
                    break;
                }
                Item tweet = tweets.remove(0);
                res.add(tweet.id);
                System.out.println("Element is " + tweet.id);

                insert(tweetslist, tweets);
            } else {
                break;
            }
        }

        System.out.println("newsfeed is " + res);

        return res;

    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }

        Set<Integer> followees = followings.get(followerId);
        if (null == followees) {
            followees = new HashSet<Integer>();
            followings.put(followerId, followees);
        }

        followees.add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees = followings.get(followerId);
        if (null != followees) {
            followees.remove(followeeId);
        }
    }


    static public void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 4);
        twitter.postTweet(2, 5);
        twitter.follow(1, 2);
        twitter.getNewsFeed(1);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */