package hot100.exercise0101;

/**
 * 第二种实现方式：
 * 当传入的节点为空或者没有子节点时，一定是对称的。
 * 当传入的节点存在子节点
 * 如果左右子节点不相同，不对称
 * 如果左右子节点有一个为空，不对称
 * 如果左子节点左孩等于有子节点右孩且左子节点右孩等于右子节点左孩，对称
 */
public class MirrorBinaryTree2 {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        if(t1.val != t2.val) return false;
        return check(t1.left, t2.right) && check(t1.right, t2.left);
    }
}
