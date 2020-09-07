package hot100.exercise0560;

/*
给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
示例 1 :
输入:nums = [1,1,1], k = 2
输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
说明 :
数组的长度为 [1, 20,000]。
数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 */

import java.util.HashMap;

/**
 * 思路：
 * 暴力法：双重循环，时间复杂度O(n^2)；显然不可取。
 * 尝试动态规划：
 * 定义一个二维数组dp[nums.length-1][nums.length];
 * 其中dp[i][j]表示数组nums中从i索引到j索引值的和。
 * 则dp[i][j]的传递函数是：dp[i][j] = dp[i][j-1]+nums[j];
 * 最后统计dp数组中值为k的个数。
 * 但是这种动态规划的时间复杂度还是O(n^2)；不可取
 *
 * 最终解法 前缀和：
 * 定义一个HashMap，将从nums[0]开始的数累加起来，放进hashmap中，键为和，值为出现的次数。
 * 然后每次遍历到一个数的时候，就去map中找当前值-k的结果有没有出现过，出现过几次，count就加上几次。
 * 最后返回count
 *
 */
public class SubArraySumAsK {
    public static void main(String[] args) {
        int[] nums = {3,4,7,2,-3,1,4,2};
        int k = 7;
        SubArraySumAsK s = new SubArraySumAsK();
        int count = s.subarraySum(nums,k);
        System.out.println(count);
    }
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            int temp = sum-k;
            if(temp==0){
                count++;
            }
            if(map.get(temp)!=null){
                count += map.get(temp);
            }
            if(map.get(sum)==null){
                map.put(sum,1);
            } else {
                map.put(sum,map.get(sum)+1);
            }
        }
        return count;
    }
}
