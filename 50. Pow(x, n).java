public class Solution {
    public double myPow(double x, int n) {
        // Handle the case when n is Integer.MIN_VALUE
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return powHelper(x, N);
    }

    private double powHelper(double x, long n) {
        if (n == 0) return 1.0;
        double half = powHelper(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
