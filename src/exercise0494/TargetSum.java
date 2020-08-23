package exercise0494;

/*
给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
示例：
输入：nums: [1, 1, 1, 1, 1], S: 3
输出：5
解释：
-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
一共有5种方法让最终目标和为3。
提示：
数组非空，且长度不会超过 20 。
初始的数组的和不会超过 1000 。
保证返回的最终结果能被 32 位整数存下。
 */

import exercise0114.Tree2List;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * 思路：
 * 直观思路，使用回溯，遍历每一种情况，对的所有符合的结果。
 */
public class TargetSum {
    public static void main(String[] args) {
        TargetSum t = new TargetSum();
        int[] nums = {1,1,1,1,1};
        int count = t.findTargetSumWays(nums,3);
        System.out.println(count);
    }

    private int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        if(nums==null||nums.length==0){
            return count;
        }
        recursion(nums,S,0);
        return count;
    }
    private void recursion(int[] nums,int S,int index){
        if(index==nums.length){
            if(S==0) {
                count += 1;
            }
            return;
        }
        recursion(nums,S-nums[index],index+1);
        recursion(nums,S+nums[index],index+1);
    }
}
