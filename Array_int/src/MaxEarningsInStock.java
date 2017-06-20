/**
 * Created by hahaha on 2017/5/9.
 * Question:
 *  `   给你一个回顾历史的机会，已知一支股票连续n天的价格走势，以长度为n的整数数组表示，数组中第i个元素（prices[i]）代表该股票第i天的股价。
 *      假设你一开始没有股票，但有至多两次买入1股而后卖出1股的机会，并且买入前一定要先保证手上没有股票。若两次交易机会都放弃，收益为0。
 *      设计算法，计算你能获得的最大收益。
 *      输入数值范围：2<=n<=100,0<=prices[i]<=100
 * Solution:
 *      1 分两部分计算 O(n²)
 *          getMax()计算买一次卖一次最大
 *          maxEarning计算总收益最大
 *      2 动态规划
 *          O(n)
 */
public class MaxEarningsInStock {
    public static void main(String[] args) {
        int[] a = new int[100000];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 1000000);
        }
        long time1 = System.nanoTime();
        System.out.print(maxEarning1(a));
        long time2 = System.nanoTime();
        System.out.println("            time: " + (time2 - time1));

        System.out.print(maxEarning2(a));
        long time3 = System.nanoTime();
        System.out.println("            time: " + (time3 - time2));
    }

    public static int getMax(int[] a, int begin, int end) {
        int max = 0;
        int min = a[begin];
        for (int i = begin; i < end; i++) {
            if (a[i] - min > max)
                max = a[i] - min;
            if (a[i] < min) {
                min = a[i];
            }
        }
        return max;
    }

    public static int maxEarning1(int[] a) {
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            max = Math.max(getMax(a, 0, i) + getMax(a, i, a.length), max);
        }
        return max;
    }


    public static int maxEarning2(int[] a) {
        int buy1 = Integer.MIN_VALUE;
        int buy2 = Integer.MIN_VALUE;
        int sell1 = 0;
        int sell2 = 0;

        for (int i : a) {
            sell2 = Integer.max(sell2, buy2 + i);
            buy2 = Integer.max(buy2, sell1 - i);
            sell1 = Integer.max(sell1, buy1 + i);
            buy1 = Integer.max(buy1, -i);
        }

        return sell2;
    }
}