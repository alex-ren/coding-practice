package org.plaintech.coding;

import java.util.*;

public class Fraction2RecurringDecimal {
    private String addSign(int sign, String num) {
        if (sign < 0) {
            return "-" + num;
        } else {
            return num;
        }
    }
    public String fractionToDecimal(int numerator, int denominator) {
        if (0 == numerator) {
            return "0";
        }

        int signed1 = 1;
        int signed2 = 1;
        long lnum = numerator;
        long lden = denominator;
        if (lnum < 0) {
            signed1 = -1;
            lnum = 0 - lnum;
        }

        if (lden < 0) {
            signed2 = -1;
            lden = 0 - lden;
        }

        int sign = signed1 * signed2;

        long M = lnum / lden;
        long n = lnum % lden;

        if (0 == n) {
            return addSign(sign, Long.toString(M));
        }


        StringBuffer buf = new StringBuffer();
        Map<Long, Integer> map = new HashMap<Long, Integer>();

        int pos = 0; // index starting from 0 for fraction digits
        int start = -1;

        while (true) {

            map.put(n, pos);
            n = n * 10;
            long m = n / lden;
            n = n % lden;

            buf.append(Long.toString(m));

            if (0 == n) {
                break;
            }

            Integer v = map.get(n);
            if (null != v) {
                start = v;
                break;
            } else {
                pos++;
            }
        }

        if (-1 != start) {
            buf.insert(start, '(');
            buf.append(")");
        }

        return addSign(sign, Long.toString(M) + "." + buf.toString());
    }
}
