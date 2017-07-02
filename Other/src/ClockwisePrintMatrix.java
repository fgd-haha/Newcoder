import java.util.ArrayList;

/**
 * Created by ha on 4/19/2017.
 */
public class ClockwisePrintMatrix {
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> array = new ArrayList<>();
        int lieLength = matrix.length;
        int lineLength = matrix[0].length;
        int len = Math.min(lieLength, lineLength);
        for (int i = 0; i < (len + 1) / 2; i++){
            int lieEnd = lieLength - i - 1;
            int lineEnd = lineLength - i - 1;
            for (int j = i; j <= lineEnd; j++)
                array.add(matrix[i][j]);
            for (int j = i + 1; j <= lieEnd; j++)
                array.add(matrix[j][lineEnd]);
            if (lieEnd != i)                                       //判断行不要重复输出
                for (int j = lineEnd - 1; j >= i; j--)
                    array.add(matrix[lieEnd][j]);
            if (lineEnd != i)                                      //判断列不要重复输出
                for (int j = lieEnd - 1; j > i; j--)
                    array.add(matrix[j][i]);
        }
        return array;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1},{2},{3},{4},{5}};
        System.out.print(printMatrix(matrix));
    }
}