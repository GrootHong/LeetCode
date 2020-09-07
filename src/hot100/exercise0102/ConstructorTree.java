package hot100.exercise0102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
给你一个二叉树，请你返回其按层序遍历得到的节点值。 （即逐层地，从左到右访问所有节点）。
 */

/**
 * 思路：之子形打印二叉树
 * 使用队列进行遍历
 * 从根节点开始，每次遍历到一个节点时，就将这个节点弹出队列，
 * 并在队列中一次添加这个节点的左右子节点，
 * 一直到整个队列为空时，结束
 */
public class ConstructorTree {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(8);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n4.left = n2;
        n2.left = n1;
        n2.right = n3;
        n4.right = n6;
        n6.left = n5;
        n6.right = n7;
        ConstructorTree c =new ConstructorTree();
        List<List<Integer>> lists = c.levelOrder(n4);
        System.out.println(lists);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        List<TreeNode> queue1 = new LinkedList<>();
        List<TreeNode> queue2 = new LinkedList<>();
        if(root==null){
            return lists;
        }
        queue1.add(root);
        while(true){
            while(queue1.size()!=0){
                TreeNode node = queue1.remove(0);
                if(node!=null){
                    list.add(node.val);
                    queue2.add(node.left);
                    queue2.add(node.right);
                }
            }
            List<Integer> l = new ArrayList<>(list.size());
            if(list.size()!=0){
                for(int i: list){
                    l.add(i);
                }
                lists.add(l);
            }
            list.removeAll(list);
            while(queue2.size()!=0){
                TreeNode node = queue2.remove(0);
                if(node!=null){
                    list.add(node.val);
                    queue1.add(node.left);
                    queue1.add(node.right);
                }
            }
            List<Integer> ll = new ArrayList<>(list.size());
            if(list.size()!=0){
                for(int i: list){
                    ll.add(i);
                }
                lists.add(ll);
            }
            list.removeAll(list);
            if(queue1.size()==0&&queue2.size()==0){
                return lists;
            }
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
