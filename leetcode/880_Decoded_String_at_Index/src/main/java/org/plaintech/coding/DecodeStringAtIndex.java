package org.plaintech.coding;

public class DecodeStringAtIndex {
    public String decodeAtIndex(String S, int K) {
        long len = 0;
        int pos = 0;
        while (pos < S.length()) {
            char c = S.charAt(pos);
            if ('a' <= c && c <= 'z') {
                len++;
            } else {
                int k = c - '0';
                len = len * k;
            }

            if (len >= K) {
                break;
            } else {
                pos++;
            }
        }

        // System.out.println("len is " + len);

        if (len < K) {
            return "";
        }

        while (pos >= 0) {
            char c = S.charAt(pos);
            // System.out.println("len is " + len + ", K is "+ K);
            if ('a' <= c && c <= 'z') {
                if (len == K) {
                    return c + "";
                } else {
                    len--;
                    pos--;
                }
            } else {
                int k = c - '0';
                pos--;
                len = len / k;
                K %= len;
                if (K == 0) {
                    K = (int)len;
                }
            }
        }

        return "";
    }
}
