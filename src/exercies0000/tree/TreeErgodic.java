package exercies0000.tree;

import java.util.Stack;

/**
 * 对二叉树使用循环方式进行遍历，
 */
public class TreeErgodic {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n5.left = n8;
        n5.right = n9;
        preOrder(n1);
        //inOrder(n1);
        //sufOrder(n1);
    }

    /**
     * 二叉树的后序遍历
     * @param root 二叉树的根节点
     */
    public static void sufOrder(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            root = stack.pop();
            System.out.println(root);
            if(root.left!=null){
                stack.push(root.left);
            }
            if(root.right!=null){
                stack.push(root.right);
            }
        }
    }

    /**
     * 二叉树的中序遍历
     * @param root 二叉树的根节点
     */
    public static void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            while(root.left!=null){
                root = root.left;
                stack.push(root);
            }
            root = stack.pop();
            System.out.print(root);
            if(root.right!=null){
                root = root.right;
                stack.push(root);
            }
        }
    }

    /**
     * 对二叉树进行前序遍历
     * @param root 二叉树根节点
     */
    public static void preOrder(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(true){
            root =  stack.pop();
            System.out.print(root);
            if(root.right!=null){
                stack.push(root.right);
            }
            if(root.left!=null){
                stack.push(root.left);
            }
            if(stack.empty()){
                break;
            }
        }
        System.out.println("\r\n");
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                "} --> ";
    }
}