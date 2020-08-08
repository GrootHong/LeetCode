package exercise0226;

/*
翻转一棵二叉树。
求二叉树的镜像
 */



/**
 * 思路：
 * 将二叉树的左子树的左孩子与右子树的右孩子交换
 * 左子树的右孩子与右子树的左孩子交换，递归一下
 */
public class MirrorTree {

    public static void main(String[] args) {

    }
    public TreeNode invertTree(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null)){
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if(root.left!=null){
            invertTree(root.left);
        }
        if(root.right!=null){
            invertTree(root.right);
        }
        return root;
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
