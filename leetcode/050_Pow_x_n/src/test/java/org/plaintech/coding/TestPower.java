package org.plaintech.coding;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by alexr on 6/4/19.
 */
public class TestPower {
    static double delta = 0.0001;

    @Test
    public void test01() {
        Power_x_n power = new Power_x_n();
        Assert.assertEquals(1024, power.myPow(2, 10), delta);
    }

    @Test
    public void test02() {
        Power_x_n power = new Power_x_n();
        Assert.assertEquals(1.0 / 1024, power.myPow(2, -10), delta);
    }

    @Test
    public void test03() {
        Power_x_n power = new Power_x_n();
        Assert.assertEquals(0, power.myPow(2, -2147483647), delta);
    }
}
