package org.plaintech.coding;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by alexr on 6/3/19.
 */
public class TestCodec {

    @Test
    public void test01() {
        String url = "https://leetcode.com/problems/design-tinyurl";

        System.out.println("url is " + url);
        Codec codec = new Codec();
        String decode = codec.decode(codec.encode(url));
        Assert.assertEquals(url, decode);
    }
}
