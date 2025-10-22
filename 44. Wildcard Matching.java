



public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        // Initialize dp for patterns like a*, a*b*, a*b*c* etc.
        for (int j = 2; j <= n; j += 2) {
            if (p.charAt(j - 1) == '*' && dp[0][j - 2]) {
                dp[0][j] = true;
            }
        }

        // Fill the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == '.' || pc == sc) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    char pPrev = p.charAt(j - 2);
                    if (pPrev != sc && pPrev != '.') {
                        dp[i][j] = dp[i][j - 2]; // Match zero occurrences
                    } else {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j]; // Match zero or more occurrences
                    }
                }
            }
        }

        return dp[m][n];
    }
}
