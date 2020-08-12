package exercise0098;

/*
给定一个二叉树，判断其是否是一个有效的二叉搜索树。
假设一个二叉搜索树具有如下特征：
节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
 */

import sun.reflect.generics.tree.Tree;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 思路：
 * 定义一个节点遍历，
 * 中序遍历二叉树，让定义的变量记录上一次遍历的结果
 * 如果上一次遍历的结果小于当前遍历的结果，就继续遍历，
 * 否则直接返回false。
 */
public class IsBST {

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
        IsBST i = new IsBST();
        boolean flag = i.isValidBST(n4);
        System.out.println(flag);
    }

    List<Integer> list = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        recursion(root);
        int pre = list.get(0);
        for(int i=1;i<list.size();i++){
            if(pre>=list.get(i)){
                return false;
            }
            pre = list.get(i);
        }
        return true;
    }
    private void recursion(TreeNode root){
        if(root.left!=null){
            recursion(root.left);
        }
        list.add(root.val);
        if(root.right!=null){
            recursion(root.right);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
