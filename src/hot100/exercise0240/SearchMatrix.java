package hot100.exercise0240;

/*
编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
每行的元素从左到右升序排列。
每列的元素从上到下升序排列。
示例:
现有矩阵 matrix 如下：
{
  {1,   4,  7, 11, 15},
  {2,   5,  8, 12, 19},
  {3,   6,  9, 16, 22},
  {10, 13, 14, 17, 24},
  {18, 21, 23, 26, 30}
}
给定 target = 5，返回 true。
给定 target = 20，返回 false。
 */

/**
 * 思路：
 * 从右上角开始寻找，
 * 1.如果右上角的值等于，切好找到
 * 2.如果右上角的值大于，则去除最后一列，因为最后一列都会大于目标值
 * 3.如果右上角的值小于，则去除第一列，因为第一列都会小于目标值。
 * 4.最终一定会在右上角找到目标值，如果矩阵缩完还没找到，则返回false。
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }
        int row = 0;
        int col = matrix[0].length-1;
        while(row<matrix.length&&col>=0){
            if(matrix[row][col]==target){
                return true;
            } else if (matrix[row][col]>target){
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}