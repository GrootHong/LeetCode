package hot100.exercise0337;

/*
在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。
除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
示例 1:
输入: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \
     3   1

输出: 7
解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
示例 2:
输入: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \
 1   3   1

输出: 9
解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 */



import java.util.HashMap;
import java.util.Map;

/**
 * 思路：
 * 重点突破：节点和最近子节点只能二选一
 *
 */
public class Rob {
    Map<TreeNode,Integer> f = new HashMap<TreeNode,Integer>();
    Map<TreeNode,Integer> g = new HashMap<TreeNode,Integer>();
    public int rob(TreeNode root) {
        if(root==null){
            return 0;
        }
        sufOrder(root);
        return Math.max(f.getOrDefault(root,0),g.getOrDefault(root,0));
    }

    private void sufOrder(TreeNode root){
        if(root==null){
            return;
        }
        sufOrder(root.left);
        sufOrder(root.right);
        f.put(root,root.val+g.getOrDefault(root.left,0)+g.getOrDefault(root.right,0));
        g.put(root, Math.max(g.getOrDefault(root.left,0),f.getOrDefault(root.left,0))
                    +Math.max(g.getOrDefault(root.right,0),f.getOrDefault(root.right,0)));
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