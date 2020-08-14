package exercise0221;

/*
在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
示例:
输入:
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
输出: 4
 */

/**
 * 思路：动态规划
 * 定义一个二维数组dp[][],其中dp[i][j]表示下表为i，j的位置的最大正方形的边长。
 * 对于第一行和第一列，dp[i][j]最大为1，
 * 对于值为0的位置，dp[i][j]=0;
 * 对于其他位置，dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1;
 * 上述操作dp数组的同时，定义一个max变量，记录最大边长，最后返回max^2.
 */
public class LargestSquare {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return max;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]=='1'){
                max = 1;
                dp[i][0] = 1;
            }
        }
        for(int j=0;j<matrix[0].length;j++){
            if(matrix[0][j]=='1'){
                max = 1;
                dp[0][j] = 1;
            }
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                    if(dp[i][j]>max){
                        max = dp[i][j];
                    }
                }
            }
        }
        return max*max;

    }

}
