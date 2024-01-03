package leetcode;

public class LongestCommonSubsequence {

    public static void main(String args[]){
        System.out.println(longestCommonSubsequenceDP("ac", "bc"));
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        return lcs(text1, text2, text1.length(), text2.length());
    }
    static int lcs(String text1, String text2, int n, int m) {
        if (n == 0 || m == 0)
            return 0;

        if (text1.charAt(n - 1) == text2.charAt(m - 1))
            return 1 + lcs(text1, text2, n - 1, m - 1);

        return Math.max(lcs(text1, text2, n - 1, m), lcs(text1, text2, n, m - 1));
    }

    public static int longestCommonSubsequenceDP(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length(); ++i)
            for (int j = 0; j < s2.length(); ++j)
                if (s1.charAt(i) == s2.charAt(j)) dp[i + 1][j + 1] = 1 + dp[i][j];
                else dp[i + 1][j + 1] =  Math.max(dp[i][j + 1], dp[i + 1][j]);
        return dp[s1.length()][s2.length()];
    }

}
