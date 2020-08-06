package exercise0101;



/*
给定一个二叉树，检查它是否是镜像对称的。
例如，二叉树前序 [1,2,2,3,4,4,3] 是对称的。
 */



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
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        MirrorBinaryTree m = new MirrorBinaryTree();
        boolean flag = m.isSymmetric(n1);
        System.out.println(flag);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        TreeNode n = root
        TreeNode mirror = getMirror(n);
        return compare(root, mirror);

    }

    public static boolean compare(TreeNode root, TreeNode mirror) {
        boolean flag = false;
        if (root == null && mirror == null) {
            return true;
        }
        if (root.val != mirror.val) {
            return false;
        }

        //向左递归
        if (root.left != null && mirror.left != null) {
            flag = compare(root.left, mirror.left);
        } else if (root.left == null && mirror.left == null) {
            flag = true;
        }
        //向右递归
        if (flag && root.right != null && mirror.right != null) {
            return compare(root.right, mirror.right);
        } else if (flag && root.right == null && mirror.right == null) {
            return true;
        }
        return false;
    }

    public static TreeNode getMirror(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        //将根节点调换位置
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //递归，将左右子树的根节点作为参数传入
        getMirror(root.left);
        getMirror(root.right);
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

