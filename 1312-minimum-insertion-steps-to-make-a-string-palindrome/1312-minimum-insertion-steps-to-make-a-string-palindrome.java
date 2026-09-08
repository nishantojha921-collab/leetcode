class Solution {
    public int minInsertions(String s) {

        int n = s.length();

        int[][] dp = new int[n][n];

        // g = gap between i and j
        for (int g = 1; g < n; g++) {

            for (int i = 0, j = g; j < n; i++, j++) {

                if (s.charAt(i) == s.charAt(j)) {

                    dp[i][j] = dp[i + 1][j - 1];

                } else {

                    dp[i][j] = 1 + Math.min( dp[i + 1][j], dp[i][j - 1] );
                }
            }
        }

        return dp[0][n - 1];
    }
}