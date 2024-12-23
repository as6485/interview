package leetcode;

public class MaximalSquare {

    public static void main(String[] args) {
        char[][] arr = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalSquare(arr));
    }

    public static int maximalSquare(char[][] mat) {
        int n = mat.length, m = mat[0].length;
        int ans = 0;

        // Create 2d array for tabulation
        int[][] dp = new int[n + 1][m + 1];

        // Fill the dp
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {

                // If square cannot be formed
                if (mat[i][j] == 0) {
                    dp[i][j] = 0;
                    continue;
                }

                dp[i][j] = 1 + Math.min(dp[i][j + 1],
                        Math.min(dp[i + 1][j], dp[i + 1][j + 1]));

                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans;
    }
}
