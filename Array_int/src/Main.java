import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n + 1];

        for (int i = 0; i < m; i++) {
            a[in.nextInt()] = 1;
        }

        int firstkong = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] == 0 && a[i + 1] == 1) {
                firstkong = i;
                break;
            }
        }

        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = firstkong; i < n + 1; i++) {
            if (a[i] == 0) {
                int temp = 0;
                for (int j = 1; j < n + 1; j++) {
                    if (a[j] == 1) {
                        temp += Math.abs(i - j);
                    }
                }
                if (temp < min) {
                    min = temp;
                    index = i;
                }
            }
        }

        System.out.println(index);
    }
}