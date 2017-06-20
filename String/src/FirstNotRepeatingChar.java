import java.util.HashMap;

/**
 * Created by ha on 4/23/2017.
 * Question:
 *      在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置。如果字符串为空,返回-1
 * Solution:
 *      1 HashMap   key = char, value = index;
 *      2 建数组ch[z + 1]，第一遍遍历str，更新ch[], 第二遍若ch[i] == 1，则返回位置。  比1更快
 */
public class FirstNotRepeatingChar {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String s = "skfjiocuwkjosdfxkcva";
        System.out.println(FirstNotRepeatingChar1(s));
        long endTime = System.nanoTime();
        System.out.println("Time: " + (endTime - startTime));
    }

    public static int FirstNotRepeatingChar(String str) {
        if (str.isEmpty()) return -1;

        int len = str.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char key = str.charAt(i);
            if (!map.containsKey(key)) map.put(key, i);
            else if (map.get(key) != -1) map.put(key, -1);
        }
        for (Character ch : str.toCharArray())
            if (map.get(ch) != -1) return map.get(ch);

        return -1;
    }

    public static int FirstNotRepeatingChar1(String str) {
        char[] a = new char['z' + 1];
        char[] cstr = str.toCharArray();
        for (char c : cstr) a[c]++;
        for (char c : cstr) {
            if (a[c] == 1)
                return str.indexOf(c);
        }
        return -1;
    }
}