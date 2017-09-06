/**
 * 删除重复结点，1，2，3，3，4  ——>   1，2，4
 */

public class DeleteRepeatedListNode {

    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.print();
        node = deleteDuplication(node);
        if (node != null) node.print();
    }

    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }

        ListNode head = new ListNode(0);
        ListNode pre = head;
        ListNode now = pHead;

        head.next = pHead;
        while (now != null && now.next != null) {
            if (now.val == now.next.val) {
                int val = now.val;
                while (now != null && now.val == val) {
                    now = now.next;
                }
                pre.next = now;
            } else {
                pre.next = now;
                pre = now;
                now = now.next;
            }
        }

        return head.next;
    }
}