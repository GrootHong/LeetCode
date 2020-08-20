package exercise0416;

/*
给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
注意:
每个数组中的元素不会超过 100
数组的大小不会超过 200
示例 1:
输入: [1, 5, 11, 5]
输出: true
解释: 数组可以分割成 [1, 5, 5] 和 [11].
示例 2:
输入: [1, 2, 3, 5]
输出: false
解释: 数组不能分割成两个元素和相等的子集.
 */

/**
 * 思路：背包问题
 * 上述问题可以转换成寻找数组中数字和为sum/2
 * 1.首先遍历数组，将数组中的元素累加，得到数组总和
 * 2.如果数组总和为奇数，则直接返回false，因为不可能找到数和为小数
 * 3.如果数组总和为偶数，开始寻找数和为其一半的数。
 * 4.定义一个动态规划数组dp[nums.length][sum/2+1];
 * 对于数组中dp[i][j]表示是否在nums[0~i]中存在某些数和为j。存在即为true。
 * 5.dp[i][j] = dp[i-1][j]||dp[i-1][j-nums[i]]
 * 6.在计算完整个二维数组之后，返回dp[nums.length][sum/2]即可。
 *
 */
public class SplitArrayBySum {
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        SplitArrayBySum s = new SplitArrayBySum();
        boolean flag = s.canPartition(nums);
        System.out.println(flag);
    }
    public boolean canPartition(int[] nums) {
        if(nums==null||nums.length==0){
            return false;
        }
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        if(sum%2==1){
            return false;
        }
        sum  /= 2;
        boolean[][] dp = new boolean[nums.length][sum+1];
        dp[0][0] = true;
        dp[0][1] = nums[0]==1?true:false;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<sum+1;j++){
                if(dp[i-1][j]||(j>=nums[i]&&dp[i-1][j-nums[i]])){
                    dp[i][j] = true;
                }
            }
        }
        return dp[nums.length-1][sum];
    }
}
