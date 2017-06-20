import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by ha on 4/22/2017.
 * Question:
 *      输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *      例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * Solution:
 *      比较器
 */
public class PrintMinNumber {
    public static void main(String[] args) {
        int[] array_int = {1, 2, 3, 23, 4, 54};
        System.out.println(PrintMinNumber(array_int));
    }
    public static String PrintMinNumber(int [] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer i : numbers) {
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1 = o1 + "" + o2;                                         //划重点：str = int + "" + int;
                String str2 = o2 + "" + o1;
                return str1.compareTo(str2);
            }
        });
        StringBuilder s = new StringBuilder();
        for (Integer i : list) {
            s.append(String.valueOf(i));
        }
        return s.toString();
    }
}
