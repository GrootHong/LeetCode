package exercise0617;

/*
给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，
否则不为 NULL 的节点将直接作为新二叉树的节点。
 */

/**
 * 思路：
 * 将两个树前序遍历，遍历到的节点相加，为空则直接加上另一个树
 */

public class MergeTree {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null&&t2==null){
            return null;
        }
        if(t1==null){
            return t2;
        }
        if(t2==null){
            return t1;
        }
        t1.val += t2.val;
        if(t1.left!=null){
            mergeTrees(t1.left,t2.left);
        } else {
            t1.left = t2.left;
        }
        if(t1.right!=null){
            mergeTrees(t1.right,t2.right);
        } else {
            t1.right = t2.right;
        }
        return t1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
