package org.plaintech.coding;

import java.util.*;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by alexr on 6/4/19.
 */
public class TestTwitter {

    @Test
    public void test01() {
        Twitter obj = new Twitter();
        obj.postTweet(1, 5);
        List<Integer> feeds = obj.getNewsFeed(1);
        Assert.assertEquals(feeds, Arrays.asList(5));

        obj.follow(1, 2);
        obj.postTweet(2, 6);


        List<Integer> feeds2 = obj.getNewsFeed(1);
        Assert.assertEquals(feeds2, Arrays.asList(6, 5));

        obj.unfollow(1, 2);
        List<Integer> feeds3 = obj.getNewsFeed(1);
        Assert.assertEquals(feeds3, Arrays.asList(5));
    }

    @Test
    public void test02() {
        Twitter obj = new Twitter();
        obj.postTweet(1, 5);
        obj.follow(1, 1);

        List<Integer> feeds = obj.getNewsFeed(1);
        Assert.assertEquals(feeds, Arrays.asList(5));
    }

    @Test
    public void test03() {
        Twitter obj = new Twitter();
        obj.postTweet(1, 4);
        obj.postTweet(2, 5);
        obj.unfollow(1, 2);
        obj.follow(1, 2);

        List<Integer> feeds = obj.getNewsFeed(1);
        Assert.assertEquals(feeds, Arrays.asList(5, 4));

    }
}
