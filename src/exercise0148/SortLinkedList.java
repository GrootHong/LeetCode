package exercise0148;

/*
在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
示例 1:
输入: 4->2->1->3
输出: 1->2->3->4
示例 2:
输入: -1->5->3->4->0
输出: -1->0->3->4->5
 */

/**
 * 思路：
 * 原地归并？还得使用迭代，不能归并！
 * 1.首先定义两个指针，slow，fast，遍历一遍链表，找到链表的中间位置slow，然后将slow.next==null；将链表分为两段。
 * 2.判断这两段是否是长度都为1，都为1，则进入合并环节，不为1继续分
 * 3.合并环节，定义两个指针，分别指向两段链表，从小到大的将链表串联起来。
 *
 */
public class SortLinkedList {

    public ListNode sortList(ListNode head) {
        return null;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}