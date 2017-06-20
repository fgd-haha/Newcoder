/**
 * Created by ha on 4/22/2017.
 * Question:
 *      求出1到n区间中1出现的次数
 * Solution:
 *      1 递归
 *          eg：number(345) == number(300) + number(45) == number(300) + number(40) + number(5);
 *      2 分别对每个数位上有多少包含1的点进行分析
 *          //根据设定的整数位置，对n进行分割，分为两部分，高位n/i，低位n%i
 *          //当i表示百位，且百位对应的数>=2,如n=31456,i=100，则a=314,b=56，此时百位为1的次数有a/10+1=32（最高两位0~31），每一次都包含100个连续的点，即共有(a%10+1)*100个点的百位为1
 *          //当i表示百位，且百位对应的数为1，如n=31156,i=100，则a=311,b=56，此时百位对应的就是1，则共有a%10(最高两位0-30)次是包含100个连续点，当最高两位为31（即a=311），本次只对应局部点00~56，共b+1次，所有点加起来共有（a%10*100）+(b+1)，这些点百位对应为1
 *          //当i表示百位，且百位对应的数为0,如n=31056,i=100，则a=310,b=56，此时百位为1的次数有a/10=31（最高两位0~30）
 *          //综合以上三种情况，当百位对应0或>=2时，有(a+8)/10次包含所有100个点，还有当百位为1(a%10==1)，需要增加局部点b+1
 *          //之所以补8，是因为当百位为0，则a/10==(a+8)/10，当百位>=2，补8会产生进位位，效果等同于(a/10+1)
 *       3 计算每个数字中含有1的个数  极慢
 *
 */
public class NumberOf1Between1AndN {
    public static void main(String[] args) {
        long startTime = System.nanoTime();   //获取开始时间
        System.out.println(numberOf1Between1AndN1(1185512));
        long endTime = System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ns");
    }

    public static int numberOf1Between1AndN0(int n) {
        if (n < 1) return 0;
        if (n < 10) return 1;
        int countOf1 = 0;
        int nextInt = 0;
        int firstDigit = n;
        int digitCount = 1;
        while (firstDigit > 9) {
            firstDigit = firstDigit / 10;
            digitCount++;
        }
        nextInt = (int) (n % Math.pow(10, digitCount - 1));
        if (firstDigit > 1)
            countOf1 = (int) Math.pow(10, digitCount - 1) + (digitCount - 1) * firstDigit * (int) Math.pow(10, digitCount - 2);
        if (firstDigit == 1)
            countOf1 = nextInt + 1 + (digitCount - 1) * (int) Math.pow(10, digitCount - 2);


        return countOf1 + numberOf1Between1AndN0(nextInt);
    }


    public static int numberOf1Between1AndN1(int n) {

        int count = 0;
        long i = 1;
        for (i = 1; i <= n; i *= 10) {
            int a = (int) (n / i), b = (int) (n % i);
            if (a % 10 == 1) {
                count = (int) (count + (a + 8) / 10 * i + (b + 1));
            } else {
                count = (int) (count + (a + 8) / 10 * i);
            }
        }
        return count;
    }


    public static int numberOf1Between1AndN2(int n) {
        int num = n;
        int count = 0;// 计算数字中含有1的数字个数。
        int strLen = 0;//每个数字的长度
        for (int i = 0; i <= num; i++) {
            String str = String.valueOf(i);
            strLen = str.length();
            for (int j = 0; j < strLen; j++) {
                if (str.charAt(j) == '1') {
                    count++;
                }
            }
        }
        return count;
    }
}
