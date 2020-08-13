package exercise0152;

/*
给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
示例 1:
输入: [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
示例 2:
输入: [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。

[2,3,-2,-3,4]
 */

import exercise0053.MaxSubSecquenceSum;

/**
 * 思路：动态规划
 */
public class MaxMultiSubArray {
    public static void main(String[] args) {
        int[] a = {3,-1,4};
        MaxMultiSubArray m = new MaxMultiSubArray();
        int num = m.maxProduct(a);
        System.out.println(num);
    }

    public int maxProduct(int[] nums) {
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        int max = nums[0];
        if(max>=0){
            dp1[0] = max;
        } else {
            dp2[0] = max;
        }
        for (int i = 1; i < nums.length; i++) {
            dp1[i] = Math.max(nums[i]*dp1[i-1],Math.max(nums[i],dp2[i-1]*nums[i]));
            max = Math.max(max,dp1[i]);
            dp2[i] = Math.min(dp2[i-1]*nums[i],Math.min(nums[i],dp1[i-1]*nums[i]));
        }
        return max;
    }
}
