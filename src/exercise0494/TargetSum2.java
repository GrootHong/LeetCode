package exercise0494;

/**
 * 方法二：动态规划
 * 定义一个二维数组dp[][],其中dp[i][j]表示对于数组中前i个数，能组合得到结果为j的方法数
 * 那么状态转移方程为 dp[i][j] = dp[i-1][j-nums[i]] + dp[i-1][j+nums[i]]
 * 计算所有的结果，最后将dp[nums.length-1][S]返回即可
 *
 * 空间优化：
 * 因为状态转移方程只是用到了当前行的上一行，因此可以只使用两个数组，将上一行的数组保存起来就行。
 * 以此来减少空间使用。
 */
public class TargetSum2 {
    public static void main(String[] args) {
        TargetSum2 t = new TargetSum2();
        int[] nums = {1,1,1,1,1};
        int count = t.findTargetSumWays(nums,3);
        System.out.println(count);
    }

    public int findTargetSumWays(int[] nums, int S) {
        int[] dp = new int[2001];
        dp[nums[0] + 1000] = 1;
        dp[-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            int[] next = new int[2001];
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[sum + 1000] > 0) {
                    next[sum + nums[i] + 1000] += dp[sum + 1000];
                    next[sum - nums[i] + 1000] += dp[sum + 1000];
                }
            }
            dp = next;
        }
        return S > 1000 ? 0 : dp[S + 1000];
    }
}
