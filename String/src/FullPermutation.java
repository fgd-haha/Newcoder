import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by ha on 4/20/2017.
 * 对string进行全排列，并返回字典序
 * eg：cba
 *    abc，acb,bac,bca,cab,cba
 */
public class FullPermutation {
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> strs = new ArrayList<>();
        int len = str.length();

        if (len == 1){
            strs.add(str);
            return strs;
        }
        for (int i = 0; i < len; i++){
            String temp = new String(str);
            String sHead = String.valueOf(temp.charAt(i));
            String sNext = temp.substring(0, i) + temp.substring(i + 1);

            for (String string : Permutation(sNext)) {
                String s = sHead + string;
                if (!strs.contains(s))
                    strs.add(s);
            }
        }
        Collections.sort(strs);
        return strs;
    }

    public static void main(String[] args) {
        String s = "abccde";
        System.out.println(Permutation(s));
    }
}
