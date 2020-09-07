package hot100.exercise0094;

/*
给定一个二叉树，返回它的中序 遍历。
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 思路：
 * 中序遍历，将每个遍历到的节点放进集合中
 *
 * 找时间研究一下基于循环方式的遍历二叉树
 */
public class InfixOfTree {
    private List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null){
            return list;
        }
        if(root.left!=null){
            inorderTraversal(root.left);
        }
        list.add(root.val);
        if(root.right!=null){
            inorderTraversal(root.right);
        }
        return list;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
