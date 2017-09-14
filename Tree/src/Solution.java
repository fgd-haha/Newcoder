import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    private static ArrayList<Integer> list = new ArrayList<>();

    public void Insert(Integer num) {
        list.add(num);
        Collections.sort(list);
    }

    public Double GetMedian() {
        Collections.sort(list);
        int len = list.size();
        int res = 0;
        if (len == 1) return (double) list.get(0);
        if (len % 2 == 1) {
            return (double) list.get(((len >>> 1)));
        } else {
            return (double) (list.get(len / 2) + list.get(len / 2 - 1)) / 2.0;
        }
    }


}