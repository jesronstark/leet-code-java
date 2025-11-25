









































public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: empty string has one way to decode

        // Single character decoding
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i <= n; i++) {
            // Single digit decoding is valid if the character is not '0'
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            // Two-digit decoding is valid if the substring is between "10" and "26"
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
