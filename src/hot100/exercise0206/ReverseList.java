package hot100.exercise0206;

/*
反转一个单链表
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
 */

/**
 * 思路：
 * 使用栈将所有节点装进栈中，然后每次遍历一个，就将这个节点暂时保存，
 * 当下一个节点弹出时，将上一个节点的next指向这个刚弹出的节点，继续弹出。
 * 最后返回头节点。
 *
 * 但是，题目要求使用递归或迭代的方法实现。因此，换种思路:
 * 定义三个指针，分别指向当前节点cur，当前节点的上一个节点pre，当前节点的下一个节点next
 * 对于当前节点，将当前节点cur.next=pre, 然后pre = cur。cur = next，next= next.next;
 * 直到next节点为null，表示遍历当当前链表的最后一个节点。
 */
public class ReverseList {

    public static void main(String[] args) {
        ReverseList r = new ReverseList();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode node = r.reverseList(n1);
        System.out.println(node);
    }
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return  head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;
        while(next!=null){
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        cur.next = pre;
        return cur;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
