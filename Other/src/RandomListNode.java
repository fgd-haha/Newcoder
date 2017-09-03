/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */

public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }

    RandomListNode() {
        RandomListNode head1 = new RandomListNode(1);
        RandomListNode head2 = new RandomListNode(2);
        RandomListNode head3 = new RandomListNode(3);
        head1.next = head2;
        head2.next = head3;
        this.label = 0;
        this.next = head1;
    }

    public static void main(String[] args) {
        RandomListNode head1 = new RandomListNode();
        RandomListNode head4 = head1.Clone(head1);
        head4.print();
    }

    public void print() {
        System.out.println(this.label);
        if (this.next != null)
            this.next.print();
    }

    public static RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode p = pHead;

        while (p != null) {
            RandomListNode q = new RandomListNode(p.label);

            q.next = p.next;
            p.next = q;
            p = q.next;
        }

        p = pHead;
        RandomListNode q = p.next;
        RandomListNode qHead = p.next;
        while (p != null) {
            q.random = p.random;
            p = q.next;
            if (q.next != null)
                q = p.next;
        }

        p = pHead;
        q = qHead;
        while (p != null) {
            p.next = q.next;
            p = q.next;
            if (q.next != null) {
                q.next = p.next;
                q = q.next;
            }
        }

        return qHead;
    }
}