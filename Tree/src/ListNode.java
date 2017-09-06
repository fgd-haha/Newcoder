public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    ListNode() {
        ListNode[] nodes = new ListNode[5];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ListNode(i);
        }
        nodes[3].val = 2;
        for (int i = 0; i < nodes.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }
        this.val = nodes[0].val;
        this.next = nodes[0].next;
    }

    public void print() {
        System.out.print(this.val + "  ");
        if (this.next != null) {
            this.next.print();
        } else System.out.println();
    }
}