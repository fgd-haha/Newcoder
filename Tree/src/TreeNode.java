public class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int x) {
        val = x;
    }

    TreeNode() {
        TreeNode[] nodes = new TreeNode[5];
        nodes[0] = new TreeNode(10);
        nodes[1] = new TreeNode(5);
        nodes[2] = new TreeNode(12);
        nodes[3] = new TreeNode(4);
        nodes[4] = new TreeNode(7);
        nodes[1].left = nodes[3];
        nodes[1].right = nodes[4];
        this.val = nodes[0].val;
        this.left = nodes[1];
        this.right = nodes[2];
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.preOderPrint();
    }

    void preOderPrint() {
        System.out.print(this.val + " ");
        if (this.left != null)
            this.left.preOderPrint();
        if (this.right != null)
            this.right.preOderPrint();
    }

    void midOderPrint() {
        if (this.left != null)
            this.left.midOderPrint();
        System.out.print(this.val + " ");
        if (this.right != null)
            this.right.midOderPrint();
    }

    void afterOderPrint() {
        if (this.left != null)
            this.left.afterOderPrint();
        if (this.right != null)
            this.right.afterOderPrint();
        System.out.print(this.val + " ");
        if (this.left == null && this.right == null)
            System.out.println();
    }
}