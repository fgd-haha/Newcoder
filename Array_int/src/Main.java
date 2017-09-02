import java.util.*;

public class Main {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n;
        while (in.hasNext()) {
            n = in.nextInt();
            double[] arr = new double[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextDouble();
            }
            int start = 0;
            int end = n - 1;
            int day = 0;
            double value = 0;
            while (start <= end) {
                day++;
                if (arr[start] < arr[end]) {
                    value += arr[start] * day;
                    start++;
                } else {
                    value += arr[end] * day;
                    end--;
                }
            }

            in.nextLine();
            System.out.println((int)value);

        }
    }
}