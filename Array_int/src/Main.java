import java.util.*;

public class Main {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> ss = new ArrayList<>();
        while (in.hasNextLine()) {
            String s = in.nextLine();
            if (s.length() != 0)
                ss.add(s);
            else break;
        }

        ArrayList<Integer> num = new ArrayList<>();
        ArrayList<Integer> maxlen = new ArrayList<>();
        for (String s : ss) {
            String[] str = s.split(" ");
            String chang = str[0];
            String duan = str[1];
            int len = getLen(chang, duan);
            num.add(num(len));
            maxlen.add(len);
        }
        for (int i = 0; i < ss.size(); i++) {
            System.out.println(num.get(i) + " " + maxlen.get(i));
        }
    }

    static int getLen(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        String min = null;
        String max = null;
        String target = null;
        min = len1 <= len2 ? s1 : s2;
        max = len1 > len2 ? s1 : s2;

        for (int i = min.length(); i >= 1; i--) {
            for (int j = 0; j <= min.length() - i; j++) {
                target = min.substring(j, j + i);
                for (int k = 0; k <= max.length() - i; k++) {
                    if (max.substring(k, k + i).equals(target)) {
                        return i;
                    }
                }
            }
        }
        return 0;
    }

    public static int num(int len) {
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += i + 1;
        }
        return res;
    }
}