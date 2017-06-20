/**
 * Created by ha on 4/24/2017.
 * Question:
 *      统计一个数字在排序数组中出现的次数。
 * Solution:
 *      1 暴力查找
 *      2 二分查找
 */
public class GetNumberOfK {
    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 3, 4, 4, 4, 5,6,8,8,8,8,9,10};
        System.out.println(GetNumberOfK1(array, 8));
    }

    public static int GetNumberOfK1(int[] array, int k) {
        int count = 0;
        for (int i : array)
            if (i == k) count++;
        return count;
    }

    public static int GetNumberOfK2(int[] array, int k) {
        return binarySerchK(array, 0, array.length - 1, k);
    }

    public static int binarySerchK(int[] array, int low, int hi, int k) {
        if (array.length == 0) return 0;
        int count = 0;
        int mid = (low + hi) / 2;
        if (k < array[low] || k > array[hi]) return 0;
        else if (k == array[low]) {
            for (int i = low; i < hi; i++) {
                if (k == array[i]) count++;
                else break;
            }
        }
        else if (k < array[mid]) return binarySerchK(array, low, mid, k);
        else if (k == array[mid]) {
            for (int i = mid; i >= low; i--) {
                if (k == array[i]) count++;
                else break;
            }
            for (int i = mid + 1; i <= hi; i++) {
                if (k == array[i]) count++;
                else break;
            }
        }
        else if (k < array[hi]) return binarySerchK(array, mid, hi, k);
        else for (int i = hi; i > mid; i--) {
                if (k == array[i]) count++;
                else break;
             }

        return count;
    }
}
