package hot100.exercise0046;

/*
给定一个 没有重复 数字的序列，返回其所有可能的全排列。
示例:
输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 思路：
 * 1.首先判断输入数组是否符合，符合则继续
 * 2.对数组进行遍历，每遍历到一个数字，就向list集合中添加一个数字，
 * 3.然后剔除这个数字，将剩下的数组进行递归。
 * 4.在递归到数组长度为0时，将list集合中的数添加到总集合，然后退出本次递归
 * 5.当递归一层结束，将list集合中的最后一个数组删除。进行后续操作
 *
 * 问题：剔除这个数字的方法是个难点。
 * 定义一个指针记录当前遍历过几个数，当遍历到某个数是，就将当前数与数组中集合长度-1位置的数交换，
 * 然后后面的遍历是从数组中指针位置开始遍历。
 */
public class Permutation {

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        Permutation p = new Permutation();
        List<List<Integer>> lists = p.permute(a);
        System.out.println(lists);
    }
    private List<List<Integer>> lists = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums==null||nums.length==0){
            return lists;
        }
        recursion(nums,0);
        return lists;
    }
    private void recursion(int[] nums,int index){
        //当list集合大小与数组长度相等时，结束递归
        if(index==nums.length){
            List<Integer> lst = new ArrayList<>(list.size());
            for(int i=0;i<list.size();i++){
                lst.add(list.get(i));
            }
            lists.add(lst);
            return;
        }
        for(int i=index;i<nums.length;i++){
            list.add(nums[i]);
            //将当前数与index位置的数交换位置
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
            recursion(nums,index+1);
            //退出递归，要将交换的位置交换回来
            temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
            list.remove(list.size()-1);
        }

    }
}
