import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by ha on 4/24/2017.
 * Question:
 *      一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * Solution:
 *
 */
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class FindNumsAppearOnce {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int[] array = new int[1000000];
        for (int i = 499999; i > 0; i--) {
            array[i] = i;
            array[i + 500000] = i;
        }
        array[500000] = 33333;
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        FindNumsAppearOnce1(array, num1, num2);
        System.out.println(num1[0] + " " + num2[0]);
        long endTime = System.nanoTime();
        System.out.println("Time: " + (endTime - startTime));
    }

    public static void FindNumsAppearOnce0(int [] array,int num1[] , int num2[]) {
        num1[0] = -1;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : array) {
            if (!hashSet.contains(i)) hashSet.add(i);
            else hashSet.remove(i);
        }
        for (int i : hashSet) {
            if (num1[0] == -1) num1[0] = i;
            else num2[0] = i;

        }
    }

    public static void FindNumsAppearOnce1(int [] array,int num1[] , int num2[]) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i : array) {
            if (!arrayList.contains(i)) arrayList.add(i);
            else arrayList.remove(arrayList.indexOf(i));
        }
        num1[0] = arrayList.get(0);
        num2[0] = arrayList.get(1);
    }
}
