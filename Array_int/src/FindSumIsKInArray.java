//n个数，找到和为k的数

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FindSumIsKInArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int key = scan.nextInt();
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        boolean[] visisted = new boolean[n];
        backTrack(arr, visisted, 0, 0, key, lists);
        System.out.println(lists);
    }

    public static void backTrack(int[] arr, boolean[] visited, int n, int sum, int key, ArrayList<ArrayList<Integer>> lists) {
        if (sum > key)
            return;
        if (n > arr.length)
            return;
        if (sum == key) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (visited[j]) {
                    list.add(arr[j]);
                }
            }
            lists.add(list);
        }
        for (int i = n; i <= arr.length - 1; i++) {
            if (!visited[i]) {
                sum += arr[i];
//                System.out.println(sum);
                visited[i] = true;
                backTrack(arr, visited, i + 1, sum, key, lists);
                visited[i] = false;
                sum -= arr[i];
                while (i < arr.length - 1 && arr[i] == arr[i + 1])
                    i++;
            }
        }
    }
}
