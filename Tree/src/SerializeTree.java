public class SerializeTree {

    private int index = -1;

    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        node.preOderPrint();
        System.out.println();
        SerializeTree so = new SerializeTree();
        so.Deserialize(so.Serialize(node)).preOderPrint();
    }

    String Serialize(TreeNode root) {
        if (root == null) return "#,";

        return (root.val + ",") +
                Serialize(root.left) +
                Serialize(root.right);
    }

    TreeNode Deserialize(String str) {
        index++;
        String[] ss = str.split(",");

        if (index >= ss.length) return null;

        if (!ss[index].equals("#") && !ss[index].equals("")) {
            TreeNode root = new TreeNode(Integer.parseInt(ss[index]));
            root.left = Deserialize(str);
            root.right = Deserialize(str);
            return root;
        } else return null;
    }
}