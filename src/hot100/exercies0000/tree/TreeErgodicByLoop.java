package hot100.exercies0000.tree;

import java.util.Stack;

/**
 * 实现循环遍历二叉树
 */
public class TreeErgodicByLoop {
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
        //preOrder(n1);
        inOrder(n1);
        //sufOrder(n1);
    }

    /**
     * 前序遍历
     * 定义一个栈，将根节点放进栈中
     * 当栈不空的情况下，每次从栈种弹出一个节点，
     * 将该节点的右，左子节点添加到栈中，
     * 这样在每次弹出得节点，都能保证下一弹出得节点是当前节点得左子节点，
     * 如果左子节点没有了，就会开始弹出右子节点，
     * 从而达到前序遍历得效果。
     *
     * @param root
     */
    private static void preOrder(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            root = stack.pop();
            System.out.println(root);
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
    }

    /**
     * 中序遍历
     * 定义一个栈，将根节点添加到栈中，
     * 在栈不空得情况下，判断
     * 如果根节点得左子节点不为空，则一直将左子节点添加到栈中。
     * 当最左子节点添加到栈中之后，将其弹出，并设为root，
     * 然后判读root右子节点。
     * 整体思路就是先将所有得左子节点装起来，然后从最下面最子节点开始，
     * 挨个向上遍历，输出左中右节点，完成中序遍历。
     * @param root
     */
    private static void inOrder(TreeNode root){
       if(root==null){
           return;
       }
       Stack<TreeNode> stack = new Stack<TreeNode>();
       stack.push(root);
       while(!stack.empty()){
           while(root.left!=null){
               root = root.left;
               stack.push(root);
           }
           root = stack.pop();
           System.out.println(root);
           if(root.right!=null){
               root = root.right;
               stack.push(root);
           }
       }
    }
}
