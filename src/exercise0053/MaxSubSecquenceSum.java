package exercise0053;

/*
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
示例:
输入: [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
进阶:
如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */

/**
 * 思路：
 * 定义两个变量，maxSum记录历史最大值，curSum记录当前遍历到的最大和
 * 从头开始遍历数组，每次遍历到一个数，就将当前的值加在curSum上，如果curSum>maxSum,就更新maxSum的值，
 * 如果curSum加上的值比前一个curSum还小，那么就记录curSum为当前遍历到的值。
 */
public class MaxSubSecquenceSum {
    public static void main(String[] args) {
        MaxSubSecquenceSum m = new MaxSubSecquenceSum();
        int[] array =  {-2,1,-3,4,-1,2,1,-5,4};
        int sum = m.maxSubArray(array);
        System.out.println(sum);
    }

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int curSum = nums[0];
        for(int i=1;i<nums.length;i++){
            //当当前和大于0，设置当前和为当前和加上当前和。
            if(curSum>0){
                curSum += nums[i];
            } else {//当前和小于等于0，设置当前和为当前遍历值
                curSum = nums[i];
            }
            //设置最大值为当前和和最大和中的大的那一个
            maxSum = Math.max(curSum,maxSum);
        }
        return maxSum;
    }
}
