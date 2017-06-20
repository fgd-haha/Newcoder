import javax.swing.plaf.metal.MetalIconFactory;
import java.util.ArrayList;

/**
 * Created by hahaha on 2017/5/25.
 * Question:
 *      Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *      For example,
 *      Given:
 *      s1 ="aabcc",
 *      s2 ="dbbca",
 *      When s3 ="aadbbcbcac", return true.
 *      When s3 ="aadbbbaccc", return false.
 * Solution:
 *      Dynamic Plan
 */
public class InterleavingString {
    public static void main(String[] args) {
        System.out.println(isInterleave("abbc", "bbdec", "abbbdecbc"));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];

        if (len1 + len2 != len3) {
            return false;
        }

        dp[0][0] = true;
        for (int i = 1; i < len1 + 1; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int j = 1; j < len2 + 1; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)
                        || dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
            }
        }
        return dp[len1][len2];
    }
}
