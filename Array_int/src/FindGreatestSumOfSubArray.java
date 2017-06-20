/**
 * Created by ha on 4/21/2017.
 * Question:
 *      求连续子数组最大和
 * Solution:
 *      动态规划
 */
public class FindGreatestSumOfSubArray {
    public static int FindGreatestSumOfSubArray(int[] array) {
        int Max = array[0];
        int len = array.length;

        if (len == 0) return 0;
        int temp = array[0] > 0 ? array[0] : 0;
        for (int i = 1; i < len; i++) {
            temp += array[i];
            Max = Math.max(Max, temp);
            if (temp < 0) {
                temp = 0;
            }
        }
        return Max;
    }

    public static void main(String[] args) {
        int[] array_int = {6, -2, -3, 7, -15, 1, 2, 2};
        System.out.println(FindGreatestSumOfSubArray(array_int));
    }
}
