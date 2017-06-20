/**
 * Created by ha on 4/23/2017.
 * Question:
 *      在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 *      并将P对1000000007取模的结果输出。 即输出P%1000000007
 * Solution:
 *      归并排序 中间加上count计数。
 */
public class InversePairs {
    private static int[] aux;                                           //归并所需辅助数组
    public static void main(String[] args) {
        int[] array_int = {1,2,3,8,5,4,7,6,9,0};
        System.out.println(InversePairs(array_int));
    }

    public static int InversePairs(int [] array) {
        aux = new int[array.length];                                    //一次性分配辅助数组空间
        if (array.length == 0) return 0;
        else return sort(array, 0, array.length - 1);
    }

    public static int sort(int[] array, int low, int hi) {
        long count = 0;
        int mid = (low + hi) / 2;
        if (low == hi) return 0;
        count += sort(array, low, mid);                                 //左半边排序
        count += sort(array, mid + 1, hi);                          //右半边排序
        count += merge(array, low, mid, hi);                            //归并
        return (int)(count % 1000000007);
    }

    public static int merge(int[] array, int low, int mid, int hi) {
        int i = low, j = mid + 1;
        long count = 0;

        for (int k = low; k <= hi; k++)
            aux[k] = array[k];

        for (int k = low; k <= hi; k++) {
            if (i > mid)                array[k] = aux[j++];
            else if (j > hi)            array[k] = aux[i++];
            else if (aux[i] < aux[j])   array[k] = aux[i++];
            else {
                                        array[k] = aux[j++];
                                        count += mid - i + 1;
            }
        }
        return (int)(count % 1000000007);
    }
}
