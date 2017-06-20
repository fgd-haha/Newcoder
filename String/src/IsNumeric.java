/**
 * Created by ha on 4/28/2017.
 * Question:
 *      判断字符串是否表示数值（包括整数和小数）。
 *      例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是.
 * Solution:
 *      1 double.parseDouble
 *      2 正则表达式
 */
public class IsNumeric {
    public static void main(String[] args) {
        System.out.println(isNumeric1("-12.234e2934".toCharArray()));
    }

    public static boolean isNumeric0(char[] str) {
        try {
            double d = Double.parseDouble(new String(str));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isNumeric1(char[] str) {
        return new String(str).matches("[+-]?(\\d*)?(\\.\\d*)?([eE][+-]?\\d+)?");

    }
}