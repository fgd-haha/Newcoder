import java.util.ArrayList;

/**
 * Created by ha on 4/25/2017.
 * Question：
 *      输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 *      对应每个测试案例，输出两个数，小的先输出。
 * Solution:
 *      双指针两头相逼。
 */
public class FindNumbersWithSum {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList = FindNumbersWithSum(array, 10);
        for (int i : arrayList) {
            System.out.println(i);
        }
    }

    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int begin = 0, end = array.length - 1;
        ArrayList<Integer> arrayList = new ArrayList<>();

        while (begin < end) {
            int sum1 = array[begin] + array[end];
            if (sum1 == sum) {
                arrayList.add(array[begin]);
                arrayList.add(array[end]);
                break;
            }
            else if (sum1 < sum) begin++;
            else if (sum1 > sum) end--;
        }

        return arrayList;
    }
}
