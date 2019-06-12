package org.plaintech.coding;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by alexr on 6/4/19.
 */
public class TestCircularArrayLoop1 {

    @Test
    public void test01() {
        CircularArrayLoop1 detector = new CircularArrayLoop1();

        int[] input = {-1, 2};
        Assert.assertEquals(false, detector.circularArrayLoop(input));
    }

    @Test
    public void test02() {
        CircularArrayLoop1 detector = new CircularArrayLoop1();

        int[] input = {-1, -1, -1};
        Assert.assertEquals(true, detector.circularArrayLoop(input));
    }

    @Test
    public void test03() {
        CircularArrayLoop1 detector = new CircularArrayLoop1();

        int[] input = {3, 3, 3};
        Assert.assertEquals(false, detector.circularArrayLoop(input));
    }
}