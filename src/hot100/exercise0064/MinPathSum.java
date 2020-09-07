package hot100.exercise0064;

/*
给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
说明：每次只能向下或者向右移动一步。
示例:
输入:
[
  {1,3,1},
  {1,5,1},
  {4,2,1}
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
 */

/**
 * 思路：
 * 应该不会采取的思路：递归全部的路径，最后找到最小路径值。肯定会超时。
 * 使用动态规划，创建一个二维数组dp[m][n],
 * 数组中dp[i][j]表示从dp[0][0]到此处的最小路径，计算方法如下
 * dp[i][j] = min(dp[i][j-1],dp[i-1][j])+dp[i][j]
 * 最后返回dp[i][j]
 */
public class MinPathSum {
    public static void main(String[] args) {
        int[][] a = {{1,3,1},
                     {1,5,1},
                     {4,2,1}};
        MinPathSum m = new MinPathSum();
        int num = m.minPathSum(a);
        System.out.println(num);
    }
    public int minPathSum(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0){
            return 0;
        }
        //创建并初始化动态规划数组
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i=1;i<grid.length;i++){
            dp[i][0] = grid[i][0]+dp[i-1][0];
        }
        for(int j=1;j<grid[0].length;j++){
            dp[0][j] += grid[0][j]+dp[0][j-1];
        }
        //开始遍历每个位置
        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                dp[i][j] = grid[i][j]+Math.min(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }


}
