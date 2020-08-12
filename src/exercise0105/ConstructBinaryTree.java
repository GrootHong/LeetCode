package exercise0105;

/*
根据一棵树的前序遍历与中序遍历构造二叉树。
注意:
你可以假设树中没有重复的元素。
例如，给出
前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7

 */

import sun.plugin.dom.core.CoreConstants;

/**
 * 思路：
 * 顺序遍历前序数组，每次遍历到一个数，就在中序数组中找到对应的数
 * 然后，在中序数组中，位于这个数之前的是左子树，
 * 位于这个数之后的是右子树
 * 在左子树中，递归，通过遍历前序数组，找到左子树的根节点，
 * 右子树中，也使用递归找到右子树的根节点，
 * 将这两个根节点连接到父节点上。
 * 遍历完前序数组，结束递归，返回根节点。
 */
public class ConstructBinaryTree {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        ConstructBinaryTree c = new ConstructBinaryTree();
        TreeNode node = c.buildTree(preorder,inorder);
        System.out.println(node);
    }

    private int[] preorder;
    private int[] inorder;
    private int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||inorder==null||inorder.length!=preorder.length){
            return null;
        }
        this.preorder = preorder;
        this.inorder = inorder;
        return recursion(0,inorder.length);
    }

    private TreeNode recursion(int start,int end){
        if(preIndex==preorder.length||start>end){
            preIndex--;
            return null;
        }
        TreeNode root = null;
        int value = preorder[preIndex++];
        for(int i=start;i<end;i++){
            if(inorder[i]==value){
                root = new TreeNode(value);
                if(i>start){
                    TreeNode left = recursion(start,i);
                    root.left = left;
                }
                if(end>i+1){
                    TreeNode right = recursion(i+1,end);
                    root.right = right;
                }
                return root;
            }
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