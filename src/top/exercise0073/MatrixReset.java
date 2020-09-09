package top.exercise0073;

/*
给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
示例 1:
输入: 
{
{1,1,1},
{1,0,1},
{1,1,1}
}
输出: 
{
  {1,0,1},
  {0,0,0},
  {1,0,1}
}
示例 2:
输入: 
{
{0,1,2,0},
{3,4,5,2},
{1,3,1,5}
}
输出: 
{
{0,0,0,0},
{0,4,5,0},
{0,3,1,0}
}

{{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}}
进阶:
一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
你能想出一个常数空间的解决方案吗？
 */

import java.util.Arrays;
import java.util.Map;

/**
 * 思路：
 * O(mn)：遍历出所有 0 元素的位置，然后置零
 * O(m+n)：直到 0 元素，然后记录第几行，第几列需要置零，遍历数组后，依次置零
 * O(1):思路清奇，遍历整个数组，遍历到0时，就将0所在行和列的第一个元素设为0，这样在第二次遍历时，
 * 只要遍历第一行和第一列，就可以设置整个数组的0。
 */
public class MatrixReset {
    public static void main(String[] args) {
        MatrixReset m = new MatrixReset();
        int[][] a = {
                {1},{2},{0},{4}
            };
        m.setZeroes(a);
        System.out.print(Arrays.deepToString(a));
    }
    public void setZeroes(int[][] matrix) {
        Boolean isCol = false;
        int R = matrix.length;
        int C = matrix[0].length;

        for (int i = 0; i < R; i++) {
            if (matrix[i][0] == 0) {
                isCol = true;
            }
            for (int j = 1; j < C; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (matrix[0][0] == 0) {
            for (int j = 0; j < C; j++) {
                matrix[0][j] = 0;
            }
        }
        if (isCol) {
            for (int i = 0; i < R; i++) {
                matrix[i][0] = 0;
            }
        }
    }

}
