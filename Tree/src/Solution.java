public class Solution {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 7, 6, 4};
        System.out.println(VerifySquenceOfBST(arr));
    }

    public static boolean VerifySquenceOfBST(int[] sequence) {
        int len = sequence.length;
        if (len == 1) {
            return true;
        } else if (len == 0) {
            return false;
        }
        return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    public static boolean VerifySquenceOfBST(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }

        int tail = sequence[end];
        int right = end;
        for (int i = start; i < end; i++) {
            if (sequence[i] > tail) {
                right = i;
                break;
            }
        }
        for (int i = right + 1; i < end; i++) {
            if (sequence[i] < tail) {
                return false;
            }
        }

        return VerifySquenceOfBST(sequence, start, right - 1) && VerifySquenceOfBST(sequence, right, end - 1);
    }
}