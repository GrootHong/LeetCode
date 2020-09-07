package hot100.exercise0236;

/*
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
示例 1:
输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
示例 2:
输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出: 5
解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
说明:
所有节点的值都是唯一的。
p、q 为不同节点且均存在于给定的二叉树中。
 */

import java.util.LinkedList;

/**
 * 思路：
 * 1.通过回溯，找到给定的两个节点所在的路径，保存在两条链表中
 * 2.然后将两条链表进行比较，最后一个公共节点自然就得到了。
 */
public class FirstParent {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(6);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(0);
        TreeNode n7 = new TreeNode(8);
        TreeNode n8 = new TreeNode(7);
        TreeNode n9 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n5.left = n8;
        n5.right = n9;
        FirstParent f = new FirstParent();
        TreeNode node = f.lowestCommonAncestor(n1,n2,n9);
        System.out.println(node);
    }
    
    private boolean pStatus = false;
    private boolean qStatus = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||p==null||q==null){
            return null;
        }
        //首先遍历数组，得到p，q所在的路径
        LinkedList<TreeNode> list1 = FindPath(root,p);
        LinkedList<TreeNode> list2 = FindPath(root,q);
        //比较两个链表，找到最后一个相同节点返回
        TreeNode node  = null;
        for(int i=0;i<list1.size()&&i<list2.size();i++){
            if(list1.get(i)!=list2.get(i)){
                if(i>0){
                    return list1.get(i-1);
                } else {
                    return null;
                }
            } else {
                node = list1.get(i);
            }
        }
        return node;
    }


    private LinkedList<TreeNode> FindPath(TreeNode root,TreeNode target){
        LinkedList<TreeNode> list = new LinkedList<>();
        recursion(root,target,list);
        return list;
    }
    private boolean recursion(TreeNode root,TreeNode target,LinkedList<TreeNode> list){
        if(root==target){
            list.add(root);
            return true;
        }
        if(root==null){
            return false;
        }
        list.add(root);
        boolean flag = false;
        if(root.left!=null){
            flag = recursion(root.left,target,list);
            if(flag){
                return flag;
            } else {
                list.removeLast();
            }
        }
        if(root.right!=null){
            flag = recursion(root.right,target,list);
            if(flag){
                return flag;
            } else {
                list.removeLast();
            }
        }
        return flag;
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
