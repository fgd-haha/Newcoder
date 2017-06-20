/**
 * Created by ha on 4/26/2017.
 * Question:
 *      n个人（编号0~(n-1))，从0开始报数，报到(m-1)的退出，剩下的人 继续从0开始报数到m-1。求胜利者的编号。
 * Solution:
 *      递归
 */
public class LastRemaining {
    public static void main(String[] args) {
        System.out.println(LastRemaining(10, 5));
    }

    public static int LastRemaining(int n, int m) {
        if (n == 1)
            return 0;
        if (n == 0)
            return -1;
        return (LastRemaining(n - 1, m) + m) % n;
    }
}
