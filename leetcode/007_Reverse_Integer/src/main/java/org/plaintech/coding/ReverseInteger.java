package org.plaintech.coding;

public class ReverseInteger {
    public int reverse(int x) {
        long y1 = 0;
        while (x != 0 ) {
            int r = x % 10;
            x = x / 10;
            y1 = y1 * 10 + r;
        }

        if (y1 < 0x80000000 || y1 > 0x7fffffff) {
            return 0;
        } else {
            return (int)y1;
        }
    }
}
