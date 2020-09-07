package hot100.exercise0019;

/*
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
示例：
给定一个链表: 1->2->3->4->5, 和 n = 2.
当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：
给定的 n 保证是有效的。
进阶：
你能尝试使用一趟扫描实现吗？
 */

/**
 * 思路：
 * 定义两个指针，首先让一个指针先走n步，
 * 然后让两个指针一起向前走，当先走的指针走到链表的最后一个节点时：
 * 后走的指针已经移动到待删除的节点的前一位，
 * 这时，只要让后指针节点的next指向next.next即可。
 *
 */
public class DeleteNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return head;
        }
        ListNode node1 = head;
        ListNode node2 = head;
        //让node1先走n步
        for(int i=0;i<=n;i++){
            if(node1!=null){
                node1 = node1.next;
            } else {
                return head;
            }
        }
        //让两者同时移动
        while(node1.next!=null){
            node1 = node1.next;
            node2 = node2.next;
        }
        //让node2.next指向next.next
        node2.next = node2.next.next;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
