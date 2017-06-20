import sun.security.util.Length;

/**
 * Created by ha on 4/28/2017.
 * Question:
 *      给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * Solution:
 *      建两个数组
 */
public class Multiply_1_to_n_But_i {
    public static void main(String[] args) {
        int[] n = {1, 2, 3, 4, 5, 6};
        int[] m = Multiply_1_to_n_But_i(n);
        for (int i : m) {
            System.out.print(i + " ");
        }
    }

    public static int[] Multiply_1_to_n_But_i(int[] n) {
        int len = n.length;
        int[] m = new int[len];
        int[] front = new int[len];
        int[] back = new int[len];
        front[0] = 1;  back[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            front[i] = front[i -1] * n[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            back[i] = back[i + 1] * n[i + 1];
        }
        for (int i = 0; i < len; i++) {
            m[i] = front[i] * back[i];
        }
        return m;
    }
}
