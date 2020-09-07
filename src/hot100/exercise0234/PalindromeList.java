package hot100.exercise0234;

/*

请判断一个链表是否为回文链表。
示例 1:
输入: 1->2
输出: false
示例 2:
输入: 1->2->2->1
输出: true

要求：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
*/

/**
 * 思路：
 * 首先将链表的前半部分反转，然后会得到两条链表，
 * 同时遍历两条链表，值不相同就是false，
 * 遍历完值相同就是true，
 * O(1)的空间复杂度用于：当链表长度为奇数时，需增加一个中间节点
 */
public class PalindromeList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(4);
        n1.next =n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        PalindromeList p = new PalindromeList();
        boolean flag = p.isPalindrome(n1);
        System.out.println(flag);
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        cur = head;
        int mid = (length - 1) / 2;
        //反转前一半的链表
        ListNode pre = null;
        ListNode next = head.next;
        for (int i = 0; i < mid; i++) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        cur.next = pre;
        ListNode node = null;
        if (length % 2 == 1) {
            node = new ListNode(cur.val);
            node.next = next;
        } else {
            node = next;
        }
        //开始同时遍历两个链表
        while (cur != null && node != null) {
            if(cur.val!=node.val){
                return false;
            }
            cur = cur.next;
            node = node.next;
        }
        return true;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
