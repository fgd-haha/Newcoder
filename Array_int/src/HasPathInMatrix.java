/**
 * Created by ha on 4/28/2017.
 * Question:
 *      请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
 *      每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 *      例如[a b c e s f c s a d e e]是3*4矩阵，其包含字符串"bcced"的路径，但是矩阵中不包含“abcb”路径，
 *      因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 * Solution:
 *      回溯
 */
public class HasPathInMatrix {
    public static void main(String[] args) {
        char[] matrix = ("ABCE" +
                         "SFCS" +
                         "ADEE").toCharArray();

        System.out.println(hasPath(matrix, 3, 4, "ABCB".toCharArray()));
    }

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

        if (rows == 0 && cols == 0) return false;
        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int[] flag = new int[matrix.length];
                if (find(matrix, flag, rows, cols, str, i, j, k))
                    return true;
            }
        }
        return false;
    }

    public static boolean find(char[] matrix, int[] flag, int rows, int cols, char[] str, int i, int j, int k) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || k == str.length) return false;
        int index = i * cols + j;
        //System.out.println(matrix[index] + " " + i +" " + j);

        if (str[k] == matrix[index] && flag[index] == 0) {
            flag[index] = 1;
            if (k == str.length - 1) return true;
            if (find(matrix, flag, rows, cols, str, i - 1, j, k + 1)
                    || find(matrix, flag, rows, cols, str, i + 1, j, k + 1)
                    || find(matrix, flag, rows, cols, str, i, j - 1, k + 1)
                    || find(matrix, flag, rows, cols, str, i, j + 1, k + 1))
                return true;
            else {
                flag[index] = 0;
                return false;
            }
        }

        return false;
    }
}
