import java.util.*;

public class Main {

    public static void main(String args[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(3);
        pq.add(7);
        pq.add(8);
        pq.add(1);
        pq.add(33);
        pq.add(66);
        pq.add(10);
        pq.add(2);

        System.out.println(pq.poll());
    }
}