package exercise2;

/*
题目2：两数相加
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class Plus2Number {
    public static void main(String[] args) {
        Plus2Number p = new Plus2Number();
        ListNode l1 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(3);
        ListNode l2 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l1.next = l3;
        l3.next = l4;
        l2.next = l5;
        l5.next = l6;
        p.addTwoNumbers(l1,l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //设置一个进位标志位，当两个相同位相加时，如果产生进位则flag为1，否则为0。
        int flag = 0;
        //同时遍历两个链表
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode pre = null;
        ListNode head = null;
        while(n1!=null&&n2!=null){
            int temp = n1.val + n2.val+flag;
            ListNode node = new ListNode(temp%10);
            if(pre==null){
                pre = node;
            } else{
                pre.next = node;
                pre = node;
            }
            if(head==null){
                head = node;
            }
            if(temp>=10){
                flag = 1;
            }else{
                flag = 0;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        //当其中一条或两条链遍历结束，将剩下的某一条链直接加在新链后面
        if(n1==null&&n2!=null){
            if(flag==0){
                pre.next=n2;
            } else{
                while(n2!=null){
                    int temp = n2.val+flag;
                    if(temp<10){
                        flag = 0;
                    }
                    ListNode node = new ListNode(temp%10);
                    pre.next = node;
                    pre = node;
                    n2 = n2.next;
                }
            }
        } else if(n1!=null&&n2==null){
            if(flag==0){
                pre.next = n1;
            } else{
                while(n1!=null){
                    int temp = n1.val+flag;
                    if(temp<10){
                        flag = 0;
                    }
                    ListNode node = new ListNode(temp%10);
                    pre.next = node;
                    pre = node;
                    n1 = n1.next;
                }
            }
        }
        if(flag==1){
            pre.next = new ListNode(1);
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}