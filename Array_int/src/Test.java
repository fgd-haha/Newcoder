import org.w3c.dom.ls.LSException;

import javax.jws.Oneway;
import javax.swing.plaf.metal.MetalIconFactory;
import java.net.SocketTimeoutException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ha on 4/25/2017.
 */

public class Test {

    public static void main(String[] args) {
        int[][] a = {{0, 0, 1}, {0, 1, 0}, {0, 1, 0}};
        System.out.println(getPermutation(3,4));
    }

    public static String getPermutation(int n, int k) {
        StringBuilder ch_i = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        int factorial = 1;

        k--;
        for (int i = 0; i < n; i++) {
            factorial *= i + 1;
            ch_i.append(i + 1 + "");
        }

        for (int i = 0; i < n; i++) {
            factorial = factorial / (n - i);
            sb.append(ch_i.charAt(k / factorial));
            ch_i.delete(k / factorial, k / factorial + 1);
            k = k % factorial;
        }

        return sb.toString();
    }
}
