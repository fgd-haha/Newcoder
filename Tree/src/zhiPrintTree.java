import java.util.ArrayList;
import java.util.LinkedList;

public class zhiPrintTree {

    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        node.midOderPrint();
        System.out.println();
        node.preOderPrint();
        System.out.println();
        node.afterOderPrint();
        System.out.println();

        ArrayList<ArrayList<Integer>> lists = Print(node);
        for (ArrayList<Integer> list : lists) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();

        if (pRoot == null) return res;

        list.add(pRoot);
        int cengNum = 1;
        boolean zuo = true;
        TreeNode tanchude;

        while (!list.isEmpty()) {
            cengNum = list.size();
            ArrayList<Integer> temp = new ArrayList<>();
            zuo = !zuo;

            for (int i = 0; i < cengNum; i++) {
                if (zuo) {
                    tanchude = list.remove();
                    if (tanchude != null) {
                        temp.add(tanchude.val);
                        list.add(tanchude.right);
                        list.add(tanchude.left);
                    }
                } else {
                    tanchude = list.removeLast();
                    if (tanchude != null) {
                        temp.add(tanchude.val);
                        list.addFirst(tanchude.left);
                        list.addFirst(tanchude.right);
                    }
                }
            }

            if (!temp.isEmpty()) res.add(temp);
        }

        return res;
    }
}