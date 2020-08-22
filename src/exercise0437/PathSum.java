package exercise0437;

/*
给定一个二叉树，它的每个结点都存放着一个整数值。
找出路径和等于给定数值的路径总数。
路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
示例：
root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1
返回 3。和等于 8 的路径有:
1.  5 -> 3
2.  5 -> 2 -> 1
3.  -3 -> 11
 */

/**
 * 思路：
 * 从根节点开始先序遍历，若当前节点大于目标值，返回上一层递归
 * 若当前节点小于目标值，则开始向左，向右递归，
 * 若当前节点等于目标值，计数器加1，方法返回。
 * 若当前节点左右都每找到，则不再向下递归。
 * ******************************************************
 *      评论区有用前缀和方法，有时间研究研究前缀和是啥
 * ******************************************************
 */
public class PathSum {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(-3);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(11);
        TreeNode n7 = new TreeNode(3);
        TreeNode n8 = new TreeNode(-2);
        TreeNode n9 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        n4.left = n7;
        n4.right = n8;
        n5.right = n9;
//        TreeNode n1 = new TreeNode(-2);
//        TreeNode n2 = new TreeNode(-3);
//        n1.right = n2;
        PathSum p = new PathSum();
        int count = p.pathSum(n1,-5);
        System.out.println(count);

    }
    private int count = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root==null){
            return 0;
        }
        recursion(root,sum);
        if(root.left!=null){
            pathSum(root.left,sum);
        }
        if(root.right!=null){
            pathSum(root.right,sum);
        }
        return count;
    }

    private void recursion(TreeNode root, int sum){
        if(root.val==sum){
            count += 1;
        }
        if(root.left!=null){
            recursion(root.left,sum-root.val);
        }
        if(root.right!=null){
            recursion(root.right,sum-root.val);
        }

    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}