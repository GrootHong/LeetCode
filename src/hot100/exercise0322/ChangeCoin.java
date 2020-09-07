package hot100.exercise0322;

/*
给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
如果没有任何一种硬币组合能组成总金额，返回 -1。
示例 1:
输入: coins = [1, 2, 5], amount = 11
输出: 3
解释: 11 = 5 + 5 + 1
示例 2:
输入: coins = [2], amount = 3
输出: -1
说明:
你可以认为每种硬币的数量是无限的。
 */

import java.util.Arrays;

/**
 * 思路：
 * 1.如果总金额小于硬币中最小硬币，返回-1。
 * 2.当总金额大于硬币中最小硬币时，采用动态规划：
 * 3.首先定义一个一位数组dp[amount+1],并且设置小于硬币最小值的索引为都设置为-1；等于硬币最小值的索引位设置位1；
 * 4.开始一次设置dp数组中的值，dp[i] = min(dp[k]+dp[i-1-k]);
 * 5.最后返回dp[amount];
 */
public class ChangeCoin {


    public static void main(String[] args) {
        int[] coins = {399,313,460,317,401,173,116,17,121};
        int amount = 7335;
        ChangeCoin c = new ChangeCoin();
        long start = System.currentTimeMillis();
        int i = c.coinChange(coins, amount);
        long end = System.currentTimeMillis();
        System.out.println(i);
        System.out.println(end-start);
    }
    public int coinChange(int[] coins, int amount) {
        if(coins==null||coins.length==0||amount<=0){
            return 0;
        }
        Arrays.sort(coins);
        if(amount<coins[0]){
            return -1;
        }
        int[] dp = new int[amount+1];
        for(int i=0;i<coins[0];i++){
            dp[i] = -1;
        }
        for(int i=0;i<coins.length&&coins[i]<dp.length;i++){
            dp[coins[i]] = 1;
        }
        int min = Integer.MAX_VALUE;
        for(int i=coins[0]+1;i<amount+1;i++){

            if(dp[i]!=0){
                continue;
            }
            for(int k=coins[0];k<i;k++){
                if(k == coins[0]&&i%coins[0]==0){
                    min = i/coins[0];
                 } else if(dp[k]!=-1&&dp[i-k]!=-1&&min>(dp[k]+dp[i-k])){
                    min = dp[k]+dp[i-k];
                }
            }
            if(min==Integer.MAX_VALUE){
                dp[i] = -1;
            } else {
                dp[i] = min;
            }
            min = Integer.MAX_VALUE;
        }
        return dp[amount];
    }
}
