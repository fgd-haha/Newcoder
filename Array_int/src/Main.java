 import java.util.*;


 public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int color = in.nextInt();
        int white = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        int z = in.nextInt();

        double value_ab = (double) x / (a + b);
        double value_c = (double)y / c;
        double value_d = (double)z / d;

        TreeMap<String, Double> map = new TreeMap<>();
        map.put("ab", value_ab);
        map.put("c", value_c);
        map.put("d", value_d);

        Comparator<Map.Entry<String, Double>> valueComparator = (o1, o2) -> (o2.getValue().compareTo(o1.getValue()));
        ArrayList<Map.Entry<String, Double>> list = new ArrayList(map.entrySet());
        list.sort(valueComparator);

        int value = 0;
        for (int i = 0; i < 3; i++) {
            String s = list.get(i).getKey();
            switch (s) {
                case "ab": {
                    int min = Math.min(color / a, white / b);
                    value += min * x;
                    color -= min * a;
                    white -= min * b;
                    break;
                }
                case "c": {
                    int min = white / c;
                    value += min * y;
                    white -= min * c;
                    break;
                }
                case "d": {
                    int min = color / d;
                    value += min * z;
                    color -= min * d;
                    break;
                }
            }
        }

        System.out.println(value);
    }
 }