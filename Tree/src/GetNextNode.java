/**
 * 返回二叉树中序遍历下一个结点。有指向上一结点的指针next。
 */

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class GetNextNode {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }

        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        } else if (pNode.next == null) {
            return null;
        } else if (pNode.next.left == pNode) {
            return pNode.next;
        } else {
            while (pNode.next != null && pNode.next.right == pNode) {
                pNode = pNode.next;
            }
            return pNode.next;
        }
    }
}