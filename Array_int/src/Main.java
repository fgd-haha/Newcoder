import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] a = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            if (a[i] == 0) count++;
        }

//        if (count % 2 == 0) {
//            System.out.println("Bob");
//        } else {
//            System.out.println("Alice");
//        }

        boolean A = true;
        for (int i = 0; i < n; i++) {
            if (a[i] == 1) {
                for (int j = i; j < n; j++) {
                    a[j] = a[j] ^ 1;
                }
                A = !A;
            }
        }
        if (A) {
            System.out.println("Bob");
        } else
            System.out.println("Alice");
    }
}  