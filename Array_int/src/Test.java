import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        HashSet<Integer> s1 = new HashSet<>();
        HashSet<Integer> s2 = new HashSet<>();
        s1.add(1);
        s2.add(2);
        s1.add(2);
        s2.add(1);
        HashSet<HashSet<Integer>> set = new HashSet<>();
        set.add(s1);
        set.add(s2);

        System.out.println(set);
    }
}