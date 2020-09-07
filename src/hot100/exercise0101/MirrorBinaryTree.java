package hot100.exercise0101;



/*
给定一个二叉树，检查它是否是镜像对称的。
例如，二叉树前序 [1,2,2,3,4,4,3] 是对称的。
 */


import java.util.ArrayList;

/**
 * 思路：
 * 先将二叉树镜像，然后将镜像和原来的对比，如果每个位置都相同，就是对称的。
 * 求镜像：前序遍历二叉树，如果当前节点有子节点，就交换子节点位置，
 */
public class MirrorBinaryTree {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(3);
        n1.left = n2;
        //n1.right = n3;
        //n2.left = n4;
        //n2.right = n4;
        //n3.left = n6;
        //n3.right = n7;
        MirrorBinaryTree m = new MirrorBinaryTree();
        boolean flag = m.isSymmetric(n1);
        System.out.println(flag);
    }

    private ArrayList<TreeNode> list = new ArrayList<>();
    private int index = 0;
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        //首先前序遍历二叉树，将其保存在集合中。
        infix(root);
        //然后将二叉树求镜像，
        TreeNode head = mirror(root);
        //最后将镜像二叉树前序遍历，并与集合中的节点进行对比，如果两个完全相同，就说明二叉树是对称的
        return compare(head);
    }

    /**
     * 对求完镜像的二叉树与原二叉树前序遍历进行比较，一旦不相同直接返回false。
     * 遍历完完全相同则返回true
     * @param head 镜像二叉树的根节点
     * @return 返回真假
     */
    private boolean compare(TreeNode head){
        //遍历到最后位置。返回true
        if(index==list.size()||(head==null&&list.get(index).val==-1)){
            return true;
        }
        //对镜像二叉树前序遍历
        boolean flag = head.val==list.get(index++).val;
        //当前节点相同，向左遍历
        if(flag&&(head.left!=null||(head.left==null&&list.get(index).val==-1))){
            flag = compare(head.left);
        }
        index++;
        if(flag&&(head.right!=null||(head.right==null&&list.get(index).val==-1))){
            flag = compare(head.right);
        }
        return flag;
    }

    /**
     * 对传入的二叉树进行镜像操作
     * @param root 传入的二叉树根节点
     * @return 返回镜像之后的二叉树根节点
     */
    private TreeNode mirror(TreeNode root){
        if(root==null){
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if(root.left!=null){
            mirror(root.left);
        }
        if(root.right!=null){
            mirror(root.right);
        }
        return root;
    }

    /**
     * 对二叉树进行前序遍历，将遍历结果保存在集合中
     * @param root 传入二叉树根节点
     */
    private void infix(TreeNode root){
        if(root==null){
            return;
        }
        list.add(root);
        if(root.left!=null){
            infix(root.left);
        } else {
            list.add(new TreeNode(-1));
        }
        if(root.right!=null){
            infix(root.right);
        } else {
            list.add(new TreeNode(-1));
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

