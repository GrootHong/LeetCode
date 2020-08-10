package exercise0039;

import java.util.*;
/*
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的数字可以无限制重复被选取。
说明：
所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
示例 1：
输入：candidates = [2,3,6,7], target = 7,
所求解集为：
[
  [7],
  [2,2,3]
]
 */

/**
 * 思路：
 * 1.将不重复数组升序排列，定义一个总和变量sum= target，定义一个集合，保存遍历到的数。
 * 2.然后对数组中的所有元素遍历，并且定义一个指针，保存当前遍历到哪一位，此指针前面的数都不再遍历范围之内
 * 3.遍历到这个数后，sum减少相应数，然后进行递归操作。
 * 4.当sum=0时，将集合添加到总集合中。
 * 5.当sum小于0时，退出递归
 * 6.退出本层递归，sum也恢复相应数。
 */
public class ArraySum {

    public static void main(String[] args) {
        int[] a = {2,3,6,7};
        int n = 7;
        ArraySum as = new ArraySum();
        List<List<Integer>> lists = as.combinationSum(a,n);
        System.out.println(lists);
    }
    List<List<Integer>> lists = new LinkedList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null||candidates.length==0){
            return lists;
        }
        //将数组排序
        Arrays.sort(candidates);
        //调用递归
        recursion(candidates,0,target);
        return lists;
    }

    private void recursion(int[] nums,int index,int target){
        //如果target==0,将集合中元素添加到总集合中
        if(target==0){
            List<Integer> l = new ArrayList<>();
            Iterator<Integer> it = list.iterator();
            while(it.hasNext()){
                l.add(it.next());
            }
            lists.add(l);
            return;
        }
        //如果target<0，直接返回
        if(target<0){
            return;
        }
        //如果target>0，则继续递归
        for(int i=index;i<nums.length;i++){
                list.add(nums[i]);
                recursion(nums,i,target-nums[i]);
                //递归结束，删除list中最后一个元素
                list.remove(list.size()-1);
        }
    }
}
