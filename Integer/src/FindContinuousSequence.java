import java.util.ArrayList;

/**
 * Created by ha on 4/24/2017.
 * Question:
 *      输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * Solution:
 *      1 先找到可能的最多连续正数个数count，从count到2，弱奇数且能整除S，序列满足，加入。
 *        若偶数，则计算相加是否为S。
 *      2 双指针问题
 *        用两个数字begin和end分别表示序列的最大值和最小值，首先将begin初始化为1，end初始化为2.如果从begin到end的和大于s，
 *        我们就从序列中去掉较小的值(即增大begin),相反，只需要增大end。一直增加begin到(1+sum)/2并且end小于sum为止。
 */
public class FindContinuousSequence {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrayLists = FindContinuousSequence(100);
        for (ArrayList<Integer> arrayList : arrayLists){
            for (Integer i : arrayList) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        int count = 0;
        for (int i = 1, sum1 = 0; sum1 < sum; i++) {
            sum1 += i; count++;
        }
        for (int i = count; i >= 2; i--) {
            int mean = sum / i;
            if (i % 2 == 1 && sum % i == 0){
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int j = mean - i / 2; j <= mean + i / 2; j++)
                    arrayList.add(j);
                arrayLists.add(arrayList);
            }
            else {
                int sum1 = 0;
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int j = mean - i / 2 + 1; j <= mean + i / 2; j++) {
                    arrayList.add(j);
                    sum1 += j;
                }
                if (sum == sum1)
                    arrayLists.add(arrayList);
            }
        }
        return arrayLists;
    }
}
