import java.util.ArrayList;

/**
 * Created by hahaha on 2017/5/19.
 * Question:
 *      输出字符串s的全部回文子序列
 *      eg： s ="aab",
 *          Return
 *                 ["aa","b"],
 *                 ["a","a","b"]
 * Solution：
 *      递归
 *      for (int i = 0; i < len; i++)
 *          s(0,i)是回文
 *              + 后面s(i, len)
 */
public class Palindrome {
    public static void main(String[] args) {
        String s = "aba82379aAba";
        s = s.replaceAll("\\W", "");
        s = s.toLowerCase();
        ArrayList<ArrayList<String>> lists = getAllPalindrom(s);
        for (ArrayList<String> list : lists) {
            System.out.println(list);
        }
    }

    public static ArrayList<ArrayList<String>> getAllPalindrom(String s) {
        int len = s.length();
        ArrayList<ArrayList<String>> lists = new ArrayList<>();

        if (len <= 0)
            return null;

        if (len == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(s);
            lists.add(list);
            return lists;
        }

        for (int i = 1; i <= len; i++) {
            String sbegin = s.substring(0, i);
            if (isPalindrome(sbegin)) {
                if (i == len) {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(s);
                    lists.add(list);
                    return lists;
                }
                else {
                    ArrayList<ArrayList<String>> endlists = getAllPalindrom(s.substring(i, len));
                    for (ArrayList<String> list : endlists) {
                        list.add(0, sbegin);
                        lists.add(list);
                    }
                }
            }
        }

        return lists;
    }

    public static boolean isPalindrome(String s) {
        char[] chs = s.toCharArray();
        for (int i = 0; i <= chs.length / 2 - 1; i++) {
            if (chs[i] != chs[chs.length - 1 - i])
                return false;
        }
        return true;
    }
}
