import javax.swing.plaf.metal.MetalIconFactory;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;


/**
 * Created by ha on 4/28/2017.
 */

public class Test {
    public static void main(String[] args) {
        int[] a = {1, 2, 23, 4};
        ArrayList<Integer> list = new ArrayList<>(100);
        for (int anA : a) {
            list.add(anA);
        }
        Integer a1 = 1000;
        Integer a2 = new Integer(1);
        Integer a3 = 1000;
        Student student = new Student();
        System.out.println(a1.equals(a3));

    }
}

class Student {
    public Integer n = 1000;
    public String toString() {
        return "haha";
    }
}