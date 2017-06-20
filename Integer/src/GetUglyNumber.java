/**
 * Created by ha on 4/22/2017.
 * Question:
 *      把只包含素因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。
 *      求按从小到大的顺序的第N个丑数
 * Solution:
 *       如果p是丑数，那么p=2^x * 3^y * 5^z，那么只要赋予x,y,z不同的值就能得到不同的丑数。
 *       现在说说算法思想：
 *          由于1是最小的丑数，那么从1开始，把2*1，3*1，5*1，进行比较，得出最小的就是1的下一个丑数，也就是2*1，
 *       这个时候，多了一个丑数‘2’，也就又多了3个可以比较的丑数，2*2，3*2，5*2，
 *       这个时候就把之前‘1’生成的丑数和‘2’生成的丑数加进来也就是(3*1,5*1,2*2，3*2，5*2)进行比较，找出最小的。。。。如此循环下去就会发现，
 *       每次选进来一个丑数，该丑数又会生成3个新的丑数进行比较。
 *
 *       上面的暴力方法也应该能解决，但是如果在面试官用这种方法，估计面试官只会摇头吧。下面说一个O（n）的算法。
 *       其实每次我们只用比较3个数：用于乘2的最小的数、用于乘3的最小的数，用于乘5的最小的数。
 *       也就是比较(2*x , 3*y, 5*z) ，x>=y>=z的，int p[] = new int[] { 0, 0, 0 }; p[0]表示最小用于乘2比较数在数组a中的【位置】。
 */
public class GetUglyNumber {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        GetUglyNumber n = new GetUglyNumber();
        System.out.println(n.GetUglyNumber_Solution(1000));
        long endTime = System.nanoTime();
        System.out.println("Time: " + (endTime - startTime));
    }



    final int d[] = {2, 3, 5};

    public int GetUglyNumber_Solution(int index) {
        if (index == 0) return 0;
        int a[] = new int[index];
        a[0] = 1;
        int p[] = new int[]{0, 0, 0};
        int num[] = new int[]{2, 3, 5};
        int cur = 1;

        while (cur < index) {
            int m = finMin(num[0], num[1], num[2]);
            if (a[cur - 1] < num[m])
                a[cur++] = num[m];
            p[m] += 1;
            num[m] = a[p[m]] * d[m];
        }
        return a[index - 1];
    }


    private int finMin(int num2, int num3, int num5) {
        int min = Math.min(num2, Math.min(num3, num5));
        return min == num2 ? 0 : min == num3 ? 1 : 2;
    }


}
