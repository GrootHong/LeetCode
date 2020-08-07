package exercise0160;

/*
编写一个程序，找到两个单链表相交的起始节点
 */

import java.util.List;
import java.util.Stack;

/**
 * 思路：
 *
 */
public class FindFirstSameNode {

    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return  null;
        }
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        //遍历headA。将所有节点装进A栈
        while(nodeA!=null){
            stackA.push(nodeA);
            nodeA = nodeA.next;
        }
        //遍历headB。将所有节点装进B栈
        while(nodeB!=null){
            stackB.push(nodeB);
            nodeB = nodeB.next;
        }
        //将AB栈同时弹出并比较，第一个不相同的两个节点的下一个节点就是第一个相同的节点
        ListNode node = null;
        while(!stackA.empty()&&!stackB.empty()){
             node = stackA.pop();
            if(node!=stackB.pop()){
                return node.next;
            }
        }

        return node;
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
