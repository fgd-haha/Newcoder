import java.util.Scanner;

/**
 * n 个数字， a1到an，问有多少不重叠的非空区间，使得每个区间内的数字异或为 0
 * 例如：
 * 输入  4
 * 3 0 2 2
 *
 * 输出  2
 */
public class Yihuo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            int n = in.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            int[] dp = new int[n];
            dp[0] = arr[0] == 0 ? 1 : 0;

//            int xor = 0;
//            HashMap<Integer, Integer> map = new HashMap<>();
//            map.put(0, -1);
//            for (int i = 0; i < n; i++) {
//                xor ^= arr[i];
//                if (map.containsKey(xor)) {
//                    int j = map.get(xor);
//                    dp[i] = j == -1 ? 1 : dp[j] + 1;
//                }
//
//            }
            for (int i = 1; i < n; i++) {
                if (arr[i] == 0) {
                    dp[i] = dp[i - 1] + 1;
                    continue;
                }
                boolean flag = false;
                int temp = arr[i];
                dp[i] = dp[i - 1];
                for (int j = i - 1; j >= 0; j--) {
                    temp ^= arr[j];
//                    System.out.println(i + "  " + j);
                    if (temp == 0) {
                        dp[i] = Math.max(dp[i - 1], dp[j - 1] + 1);
                        break;
                    }
                }
            }

            System.out.println(dp[n - 1]);
        }
    }
}
