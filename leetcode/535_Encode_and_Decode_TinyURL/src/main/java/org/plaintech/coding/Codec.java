package org.plaintech.coding;

import java.util.*;

public class Codec {

    private String seq = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private Map<String, String> map = new HashMap<String, String>();

    private static final int gLength = 6;
    private static final String tinyUrlPrefix = "http://tinyurl.com/";

    private String generateKey() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < gLength; i++) {
            int rand = random.nextInt(62);
            sb.append(seq.charAt(rand));
        }

        String key = sb.toString();
        return key;
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = generateKey();
        while (map.containsKey(key)) {
            key = generateKey();
        }
        map.put(key, longUrl);

        return tinyUrlPrefix + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String key = shortUrl.replace(tinyUrlPrefix, "");
        // System.out.println("key is " + key);
        return map.get(key);
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        String encode = codec.encode("xxx");
        // System.out.println("encode is " + encode);
        // System.out.println("decode is " + codec.decode(encode));

    }
}


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
