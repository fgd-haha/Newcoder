/**
 * Created by ha on 4/26/2017.
 * Question:
 *      求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * Solution:
 *      递归，终止条件用&&短路来处理
 */
public class SumOf1toN {
    public static void main(String[] args) {
        System.out.println(Sum(3));
    }

    public static int Sum (int n){
        int sum = n;
        boolean b = n > 0 && (sum += Sum(n - 1)) > 0 ;
        return sum;
    }
}
