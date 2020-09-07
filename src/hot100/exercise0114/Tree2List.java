package hot100.exercise0114;

/*
给定一个二叉树，原地将它展开为一个单链表。
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 思路：前序遍历
 * 对给定的二叉树进行前序遍历，并且定义一个变量记录遍历到的前一个节点
 * 每当遍历到一个节点时，就将前一个节点的right指向遍历到的节点，并将该节点的left指向前一个节点。形成双链表
 * 前序遍历结束，返回头节点即可。
 *
 */
public class Tree2List {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        Tree2List t = new Tree2List();
        t.flatten(n1);
        System.out.println(n1);
    }
    private TreeNode pre = null;
    private List<TreeNode> list = new ArrayList<>();
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        recursion(root);
        for(int i=0;i<list.size();i++){
            list.get(i).left =null;
            if(pre!=null){
                pre.right = list.get(i);
            }
            pre = list.get(i);
        }
    }


    private void recursion(TreeNode root){
        if(root==null){
            return;
        }
        list.add(root);
        if(root.left!=null){
            recursion(root.left);
        }
        if(root.right!=null){
            recursion(root.right);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}