/**
 * Question:
 *      数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *      例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 *      如果不存在则输出0。
 *
 * 采用阵地攻守的思想：
 *      第一个数字作为第一个士兵，守阵地；count = 1；
 *      遇到相同元素，count++;
 *      遇到不相同元素，即为敌人，同归于尽,count--；当遇到count为0的情况，又以新的i值作为守阵地的士兵，继续下去，到最后还留在阵地上的士兵，有可能是主元素。
 *      再加一次循环，记录这个士兵的个数看是否大于数组一般即可。
 */

public class MoreThanHalfNum {
    public static void main(String[] args) {
        int[] array_int = {1, 2, 3, 4, 5, 3, 2, 3, 3, 3, 3, 3};
        System.out.println(MoreThanHalfNum_Solution(array_int));
    }


    public static int MoreThanHalfNum_Solution(int [] array) {
        if (array.length == 0)
            return 0;

        int soldier = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {                       //soldier守擂开始
            if (array[i] == soldier) {
                count++;
            }
            else {
                count--;
                if (count == 0) {
                    soldier = array[i];
                    count = 1;
                }
            }
        }

        count = 0;
        for (int i = 0; i < array.length; i++) {                        //检验剩下soldier
            if (array[i] == soldier)
                count++;
        }
        if (count > array.length / 2)
            return soldier;
        return 0;
    }
}