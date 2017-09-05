/**
 * 获得最长公共子串长度
 */
public class GetMaxCommenString {

    public static void main(String[] args) {
        System.out.println(getMaxCommenString("abcdfesdf", "cdfe"));
    }

    static int getMaxCommenString(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int res = 0;
        if (len1 == 0 || len2 == 0) {
            return 0;
        }
        int[][] dp = new int[len1][len2];

        for (int i = 0; i < len1; i++) {
            dp[i][0] = s1.charAt(i) == s2.charAt(0) ? 1 : 0;
            res = Math.max(res, dp[i][0]);
        }
        for (int j = 0; j < len2; j++) {
            dp[0][j] = s1.charAt(0) == s2.charAt(j) ? 1 : 0;
            res = Math.max(res, dp[0][j]);
        }

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(dp[i][j], res);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return res;
    }
}
