/**
 *
 * Created by ha on 4/21/2017.
 * Question:
 *      输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *Solution:
 *      1 快速排序 n*log(n)
 *      2 冒泡排序 n*k
 *      3 堆排序  n*log(k)
 */


import java.util.ArrayList;



public class GetSmallestNumbers {
    public static void main(String[] args) {
        int[] array_int = {3, 3, 5, 2, 6, 56, 3, 4, 6, 8};
        System.out.println(GetSmallestNumbers(array_int,6));
    }


    public static ArrayList<Integer> GetSmallestNumbers(int[] array_int, int k) {
        ArrayList<Integer> arrayList_int = new ArrayList<>();
        if (k > array_int.length)                                      //判断是否越界
            return arrayList_int;


        /*
        Arrays.sort(array_int);                                        //快排
        for (int i = 0; i < k; i++) {
            arrayList_int.add(array_int[i]);
        }
        */

        for (int i = 0; i < k; i++) {                                  //冒泡思想
            for (int j = 0; j < array_int.length - i - 1; j++) {
                if (array_int[j] < array_int[j + 1]) {
                    int swap = array_int[j];
                    array_int[j] = array_int[j + 1];
                    array_int[j + 1] = swap;
                }
            }
            arrayList_int.add(array_int[array_int.length - i - 1]);
        }


        return arrayList_int;
    }
}
