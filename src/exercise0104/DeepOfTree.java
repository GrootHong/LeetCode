package exercise0104;

/*
给定一个二叉树，找出其最大深度。
二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
说明: 叶子节点是指没有子节点的节点。
 */


/**
 * 思路：
 * 使用递归，定义一个计数器，
 */
public class DeepOfTree {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return getDepth(root);

    }
    private int count =1;
    private int max = 1;
    private int getDepth(TreeNode root){
        if(root.left!=null){
            count += 1;
            if(count > max){
                max = count;
            }
            getDepth(root.left);
            count--;
        }
        if(root.right!=null){
            count+=1;
            if(max<count){
                max = count;
            }
            getDepth(root.right);
            count--;
        }
        return max;
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