package hot100.exercise0021;

/*
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
示例：
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
 */

/**
 * 思路：
 * 定义四个变量，一个为合并后的头结点，一个为合并后的当前节点，一个为链表一的当前节点，一个为链表二的当前节点，
 * 如果链表一的当前节点小于链表二的当前节点，则合并后的当前节点后一个节点为链表一的当前节点，反之亦然
 * 将链表一或链表二的当前节点向后移动一位。
 * 如果某一链表的当前节点为null，则将另一链表的后面所有节点直接添加到合并链表的后面。结束，返回合并后的头结点。
 */
public class MergeLinkedList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(7);
        ListNode n5 = new ListNode(2);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(6);
        ListNode n8 = new ListNode(8);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        MergeLinkedList m = new MergeLinkedList();
        ListNode node = m.mergeTwoLists(n1,n5);
        System.out.println(node);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        //两个链表都不为空，开始比较大小，合并
        ListNode head = null;
        ListNode mergeCur = null;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                if(mergeCur==null){
                    mergeCur = l1;
                } else {
                    mergeCur.next = l1;
                    mergeCur = l1;
                }
                l1 = l1.next;
            } else {
                if(mergeCur==null){
                    mergeCur = l2;
                } else {
                    mergeCur.next = l2;
                    mergeCur = l2;
                }
                l2 = l2.next;
            }
            if(head==null){
                head = mergeCur;
            }
        }
        //当两个链表中有一个为null时
        if(l1==null){
            mergeCur.next = l2;
        }
        if(l2==null){
            mergeCur.next = l1;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}