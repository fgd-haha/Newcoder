/**
 * Created by ha on 4/26/2017.
 * Question:
 *      写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * Solution:
 *      我们可以用三步走的方式计算二进制值相加： 5-101，7-111
 *      第一步：相加各位的值，不算进位，得到010，二进制每位相加就相当于各位做异或操作，101^111。
 *      第二步：计算进位值，得到1010，相当于各位做与操作得到101，再向左移一位得到1010，(101&111)<<1。
 *      第三步重复上述两步， 各位相加 010^1010=1000，进位值为100=(010&1010)<<1。
 *      继续重复上述两步：1000^100 = 1100，进位值为0，跳出循环，1100为最终结果。
 */
public class Num1AddNum2 {
    public static void main(String[] args) {
        System.out.println(Num1AddNum2(5, 7));
    }

    public static int Num1AddNum2(int num1, int num2) {
        int flag = 1;
        while (flag != 0) {
            flag = (num1 & num2) << 1;     //进位值
            num1 = num1 ^ num2;            //不进位相加值
            num2 = flag;
        }
        return num1;
    }
}
