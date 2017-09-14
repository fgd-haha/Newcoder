//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Scanner;
//
//public class DateTest {
//
//    private static int[] aa = new int[100];
//    private static int[] bb = new int[100];
//    private static int n, k;
//
//
//
//    public static void main(String[] args){
//
//        Scanner in = new Scanner(System.in);
//
//        String s = in.nextLine();
//
//        String[] ss = s.split(",");
//        int n = Integer.parseInt(ss[0]);
//        System.out.println(n);
//        if (n < 3) {
//            System.out.println("incorrect data");
//            return;
//        }
//
//        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        DateTest begin;
//        DateTest end;
//        try {
//            begin =sdf.parse(ss[1]);
//            end = sdf.parse(ss[2]);

//            System.out.println(begin);
//            System.out.println(end);
//            long diff = end.getTime() - begin.getTime();
//            long minute = diff / (1000 * 60);
//            if (minute < 0) System.out.println("incorrect data");
//            int quan = (int) ((minute + 5) / (n * 15));
//
//            for (int i = 0; i < n; i++) {
//                minute -= 10;
//                if (minute < 0) {
//                    if (i == n - 1) {
//                        System.out.print(quan + ";");
//                        System.out.print(i + 1);
//                        System.out.print('-');
//                        System.out.print(1);
//                        break;
//                    } else
//                        System.out.println(quan + ";" + i + 1 + "-" + i + 2);
//                    break;
//                }
//                minute -= 5;
//                if (minute < 0) {
//                    System.out.println(quan + ";" + i + 1 + "-" + i + 1);
//                    break;
//                }
//
//                if (i == n - 1) i = 0;
//            }
//        } catch (ParseException e) {
//            System.out.println("incorrect data");
//        }
//    }
//}
