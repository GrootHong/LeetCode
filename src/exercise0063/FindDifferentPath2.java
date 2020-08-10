package exercise0063;

/*
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
问总共有多少条不同的路径？
 */

import exercise0039.ArraySum;

import java.util.Arrays;

/**
 * 思路：基于动态规划求解
 *  定义一个二维数组dp[m][n]，其中dp[i][j]表示i行j列可以有多少种走法，
 *  初始化数组 dp[0][j] = dp[i][0] = 1;
 *  然后剩下的元素dp[i][j] = dp[i-1][j],且dp[i][j]=dp[j][i];
 *  最后返回dp[m-1][n-1]
 */
public class FindDifferentPath2 {
    public static void main(String[] args) {
        FindDifferentPath2 f = new FindDifferentPath2();
        int count = f.uniquePaths(7,3);
        System.out.println(count);
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //初始化数组
        Arrays.fill(dp[0],1);
        for(int i=0;i<m;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
