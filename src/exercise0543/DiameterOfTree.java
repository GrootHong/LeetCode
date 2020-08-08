package exercise0543;

/*
给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
这条路径可能穿过也可能不穿过根结点。
注意：两结点之间的路径长度是以它们之间边的数目表示。
 */

/**
 * 思路：
 * 遍历树中的每个节点。计算每个节点的左子树+右子树长度，并将每次的最大值保存
 */
public class DiameterOfTree {

    public static void main(String[] args) {

    }

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        getDeep(root);
        return max;
    }

    private int getDeep(TreeNode root) {
        int leftLen = root.left == null ? 0 : getDeep(root.left) + 1;
        int rightLen = root.right == null ? 0 : getDeep(root.right) + 1;
        max = max > (leftLen + rightLen) ? max : (leftLen + rightLen);
        return leftLen > rightLen ? leftLen : rightLen;
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