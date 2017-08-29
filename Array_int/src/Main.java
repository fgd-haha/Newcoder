 import com.sun.media.sound.SoftTuning;

 import java.net.SocketTimeoutException;
 import java.util.*;


 public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] a = new int[m];

            for (int i = 0; i < m; i++) {
                a[i] = in.nextInt();
            }

//        System.out.println(Arrays.toString(a));

            int[] result = new int[1000000];
            int count;
            int j = 0;
            result[0] = a[0];

            if (a[0] == 1) result[1] = a[1];
//        System.out.println(result[0]);
            int t = 0;
            for (int i = 0; i < m; i++) {
                count = result[t++];
                for (int k = 0; k < count; k++) {
                    result[j++] = a[i];
                }

                if (j == n || t == n) {
                    break;
                }

                if (i == m - 1) i = -1;
            }

            for (int i = 0; i < n; i++) {
                System.out.println(result[i]);
            }
        }
    }
 }







//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextLine()) {
//            String[] ss = (in.nextLine().split(" "));
//
//            ArrayList<Integer[]> list = new ArrayList<>();
//            int[] line = new int[6];
//            boolean end = true;
//            for (int i = 0; i < 6; i++) {
//                line[i] = Integer.parseInt(ss[i]);
//                if (line[i] != 0) {
//                    end = false;
//                }
//            }
//
//            ArrayList<Integer> result = new ArrayList<>();
//            if (end == true) {
//
//
//            }
//
//        }
//    }
//}