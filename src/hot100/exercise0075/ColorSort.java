package hot100.exercise0075;

import java.util.Arrays;

/*
给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
注意:
不能使用代码库中的排序函数来解决这道题。
示例:
输入: [2,0,2,1,1,0]
输出: [0,0,1,1,2,2]
进阶：
一个直观的解决方案是使用计数排序的两趟扫描算法。
首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class ColorSort {
    public static void main(String[] args) {
        int[] color = {2,0,2,1,1,0};
        ColorSort c =new ColorSort();
        c.sortColors(color);
        System.out.println(Arrays.toString(color));
    }
    public void sortColors(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zero++;
            } else if(nums[i]==1){
                one++;
            } else {
                two++;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(i<zero){
                nums[i] = 0;
            } else if(i>=zero&&i<zero+one) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}
