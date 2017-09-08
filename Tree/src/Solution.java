import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();

        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < a.length(); i++) {
            list.add(a.charAt(i));
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < b.length(); i++) {
            if (!map.containsKey(b.charAt(i))) {
                map.put(b.charAt(i), 1);
            } else {
                map.replace(b.charAt(i), map.get(b.charAt(i)) + 1);
            }
        }

        while (!list.isEmpty()) {
            ArrayList<Integer> index = new ArrayList<>();
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) == list.get(i + 1)) {
                    index.add(i);
                }
            }
            if (index.isEmpty()) {
                break;
            }
            for (int i = 0; i < index.size(); i++) {
                if (map.containsKey(list.get(index.get(i)))) {
                    list.remove(index.get(i));
                    list.remove(index.get(i) + 1);
                    map.remove(index.get(i));
                }
            }
        }



        System.out.println(list.isEmpty());
    }
}