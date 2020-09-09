package top.exercise0054;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.naming.InsufficientResourcesException;
import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
给定一个包含 m x n 个元素的矩阵（m 行, n 列），
请按照顺时针螺旋顺序，返回矩阵中的所有元素。
示例 1:
{
 { 1, 2, 3 },
 { 4, 5, 6 },
 { 7, 8, 9 }
}
输出: [1,2,3,6,9,8,7,4,5]
示例 2:
输入:
{
  {1, 2, 3, 4},
  {5, 6, 7, 8},
  {9,10,11,12}
}
输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

/**
 * 思路：
 * 前几天B站面试题考过，一模一样
 * 再自己实现一遍。争取换种思路。
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        SpiralMatrix s = new SpiralMatrix();
        List<Integer> list = s.spiralOrder(matrix);
        for(Integer i : list){
            System.out.print(i+",");
        }
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return list;
        }
        int left = 0,right = matrix[0].length-1,
                top = 0,bottom = matrix.length-1;
        int row = 0,col = 0;
        while(left<=right&&top<=bottom){
            if(col>right){
                break;
            }
            //向左
            while(col<=right){
                list.add(matrix[row][col++]);
            }
                col--;
                row++;
                top++;
            //向下
            if(row>bottom){
                break;
            }
            while(row<=bottom){
                list.add(matrix[row++][col]);
            }
                row--;
                col--;
                right--;
            //向左
            if(col<left){
                break;
            }
            while(col>=left){
                list.add(matrix[row][col--]);
            }
                row--;
                col++;
                bottom--;
            //向上
            if(row<top){
                break;
            }
            while(row>=top){
                list.add(matrix[row--][col]);
            }
                row++;
                col++;
                left++;
        }
        return list;
    }
}

















