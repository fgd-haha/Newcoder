/**
 * Created by ha on 4/25/2017.
 * Question:
 *      判断5张扑克牌是不是顺子，0代表大小王，可替代其他牌，共4个王。
 * Solution:
 *      1 max - min > 5
 *      2 除0外，不能有重复。
 */
public class IsContinuous {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 0, 5};
        System.out.println(isContinuous(nums));
    }

    public static boolean isContinuous(int[] numbers) {
        if (numbers.length != 5) return false;
        int min = 14;
        int max = -1;
        int flag = 0;
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (number < 0 || number > 13) return false;
            if (number == 0) continue;
            if (((flag >> number) & 1) == 1) return false;          //二进制位标记，检验是否重复，比数组标记节省空间
            flag |= (1 << number);
            if (number > max) max = number;
            if (number < min) min = number;
            if (max - min >= 5) return false;
        }
        return true;
    }
}
