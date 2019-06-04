package org.plaintech.coding;

class Power_x_n {
    private double myPowPos(double x, int n) {
        double res = 1;
        double xn = x;

        while (n >= 1) {
            int r = n % 2;
            if (1 == r) {
                res = res * xn;
            }
            xn = xn * xn;
            n = n / 2;
        }

        return res;
    }

    public double myPow(double x, int n) {
        if (n >= 0) {
            return myPowPos(x, n);
        } else {
            if (0x80000000 == n) {
                double temp = myPowPos(x, 0x7fffffff);
                return 1 / (temp * temp);
            }
            return 1 / myPowPos(x, -1 * n);
        }
    }
}