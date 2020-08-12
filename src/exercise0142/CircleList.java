package exercise0142;

/*
给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
如果 pos 是 -1，则在该链表中没有环。
说明：不允许修改给定的链表。
 */

import java.util.List;

/**
 * 思路：
 * 定义两个指针，两个指针同时从头开始向后移动
 * 第一个指针每次移动两个节点，第二个节点每次移动一个节点
 * 当两个节点再次相遇时，表示连边是环形链表。
 * 当第一个指针指向null时，表示不是环形链表。返回null
 * 当两个节点相遇时，将一个链表移回头节点，两个同时移动，每次均移动一步，
 * 最后相遇的位置就是环入口节点
 */
public class CircleList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;
        CircleList c = new CircleList();
        ListNode node = c.detectCycle(n1);
        System.out.println(node);
    }
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null||head.next.next==null){
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(fast!=null){
            if(slow == fast){
                break;
            }
            slow = slow.next;
            if(fast.next!=null&&fast.next.next!=null){
                fast = fast.next.next;
            } else {
                return null;
            }
        }
        fast = head;
        while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
  }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
