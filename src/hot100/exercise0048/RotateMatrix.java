package hot100.exercise0048;

/*
给定一个 n × n 的二维矩阵表示一个图像。
将图像顺时针旋转 90 度。
说明：
你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
示例 2:
给定 matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],
原地旋转输入矩阵，使其变为:
[
  {15,13, 2, 5},
  {14, 3, 4, 1},
  {12, 6, 8, 9},
  {16, 7,10,11}
]
 */

import java.util.Arrays;

/**
 * 思路：
 * 先将矩阵转置，然后将列交换
 * 1.先求转置矩阵，将矩阵中num[i][j]与num[j][i]交换
 * 2.再交换列，定义连个指针指向矩阵的第一列和最后一列
 * 3.然后循环遍历列上每一个数字，交换位置
 */
public class RotateMatrix {

    public static void main(String[] args) {
        int[][] a = {{15,13, 2, 5},
                {14, 3, 4, 1},
                {12, 6, 8, 9},
                {16, 7,10,11}};
        RotateMatrix r = new RotateMatrix();
        r.rotate(a);
        System.out.println(Arrays.toString(a[0]));
        System.out.println(Arrays.toString(a[1]));
        System.out.println(Arrays.toString(a[2]));
        System.out.println(Arrays.toString(a[3]));
    }
    public void rotate(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0||(matrix.length!=matrix[0].length)){
            return;
        }
        //转置
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix.length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //交换列位置
        int start = 0;
        int end = matrix.length-1;
        while(start<end){
            for(int i=0;i<matrix.length;i++){
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
            }
            start++;
            end--;
        }
    }
}
