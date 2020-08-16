package exercise0300;

/*
给定一个无序的整数数组，找到其中最长上升子序列的长度。
示例:
输入: [10,9,2,5,3,7,101,18]
输出: 4
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
说明:
可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
你算法的时间复杂度应该为 O(n2) 。
进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */

/**
 * 思路：
 * 不需要连续，只要大的数在小的数后面就行。
 * 不进阶
 * 使用动态规划算法， 维护一个数组dp
 * 对于数组dp，dp[i] = dp[i-k]中符合的+1
 * 最后遍历dp数组，找到最大的值
 */
public class LongestSequence {
    public int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = dp[0];
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]&&dp[i]<dp[j]){
                    dp[i] = dp[j];
                }
            }
            dp[i]++;
            if(max<dp[i]){
                max = dp[i];
            }
        }
        return max;
    }
}
