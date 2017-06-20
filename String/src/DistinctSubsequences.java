/**
 * Created by hahaha on 2017/5/25.
 * Question:
 *      Given a string S and a string T, count the number of distinct subsequences of T in S.
 *      eg: "ACE"is a subsequence of"ABCDE"while"AEC"is not
 * Solution:
 *      Dynamic Plan  动态规划
 *      dp[i][j]表示T的从0开始长度为i的子串和S的从0开始长度为j的子串的匹配的个数。
 *      初始化dp[0][0] = 1 , T和S都是空串.
 *      dp[0][1 ... slen] = 1;  T是空串，S只有一种子序列匹配
 *      dp[1 ... tlen][0] = 0;  S是空串，T没有匹配
 *      dp[i][j] = dp[i][j - 1] + (T[i - 1] == S[j - 1] ? dp[i - 1][j - 1] : 0)
 */
public class DistinctSubsequences {
    public static void main(String[] args) {
        System.out.println(numDistinct("abcdefgefg", "cdfg"));
    }

    public static int numDistinct(String S, String T) {
        int sLen = S.length();
        int tLen = T.length();
        char[] schars = S.toCharArray();
        char[] tchars = T.toCharArray();
        int[][] dp = new int[tLen + 1][sLen + 1];

        dp[0][0] = 0;
        for (int i = 0; i < tLen + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < sLen + 1; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < tLen + 1; i++) {
            for (int j = 1; j < sLen + 1; j++) {
                if (schars[j - 1] == tchars[i - 1]) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                } else dp[i][j] = dp[i][j - 1];
            }
        }

        return dp[tLen][sLen];
    }
}
