package hot100.exercise0141;

/*
给定一个链表，判断链表中是否有环。
为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 */

/**
 * 思路：
 * 先求链表中环的入口，然后判断post的数值大小，来确定链表中是否有环
 * 定义两个指针，一个快指针每次走两步，一个慢指针每次走一步
 * 当有环的情况下，
 * 快指针最终会超过慢指针一圈而与慢指针处于同一位置，此时，将快指针移回链表头，让快慢指针都按照一步一次的速度遍历，
 * 当两者再次相遇时，找到入口节点。且链表存在环、
 * 当链表没有环，则快指针一定会指向空。
 */
public class CircleLinkedList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        //n7.next = n3;
        CircleLinkedList c = new CircleLinkedList();
        boolean flag = c.hasCycle(n1);
        System.out.println(flag);
    }

    public boolean hasCycle(ListNode head) {
        if(head==null){
            return  false;
        }
        if(head.next==null||head.next.next==null){
            return false;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != null && fast != slow) {
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                return false;
            }
        }
        if(fast!=null&&fast==slow){
            return  true;
        } else {
            return false;
        }

    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
