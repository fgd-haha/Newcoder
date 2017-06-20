import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by ha on 4/27/2017.
 */
public class Test {
    public static void main(String[] args) {
        int[] a = {1,2,3,5,4,6,4};
        int[] b = {1};
        //duplicate(a, 4, b);
        //System.out.println(b[0]);
        System.out.println(countBitDiff(1999, 2999));
    }

    public static int StrToInt(String str){
        try {
            return Integer.parseInt(str);
        }catch (Exception e){
            return 0;
        }
    }
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        if (length == 0) duplication[0] = -1;
        HashSet<Integer> h = new HashSet<>();
        for (int i : numbers) {
            if (!h.contains(i))
                h.add(i);
            else {
                duplication[0] = i;
                return true;
            }
        }
        return false;
    }



    //两个int32整数m和n的二进制表达，有多少个位(bit)不同么？
    static int countBitDiff(int m, int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((m & 1) != (n & 1)) {
                count++;
            }
            m = m >> 1;
            n = n >> 1;
        }
        return count;
    }

}
