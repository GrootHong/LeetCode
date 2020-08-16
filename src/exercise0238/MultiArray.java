package exercise0238;

/*
给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
示例:
输入: [1,2,3,4]
输出: [24,12,8,6]
提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
进阶：
你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */

import java.util.Arrays;

/**
 * 思路：
 * 输出数组不算额外空间
 *
 * 使用额外空间的方法
 * 定义两个数组，记录当前索引位置的左边乘积和右边乘积，然后再对应位置相乘就是最后的结果数组。
 * 空间复杂度O(n),时间复杂度O(n).
 *
 * 使用常数空间复杂度的方法。：
 * 因为输出数组不算额外空间，那么可以将上一方法中的其中一个数组用输出数组代替，
 * 这样每次计算到对应位置的乘积时，就只要找到另一个数组的对应值就行了。
 * 另一个数组，其实并不需要是数组，只要是一个动态变化的数就行了
 * 假设另一个动态变化的数记录的是数组左边的乘积，那么在每次遍历的过程中，
 * 每次遍历一次，就在原来基础上乘以上一次遍历的值就好了。
 * 至此，分析结束。
 */
public class MultiArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        MultiArray m = new MultiArray();
        int[] temp = m.productExceptSelf(nums);
        System.out.println(Arrays.toString(temp));
    }

    public int[] productExceptSelf(int[] nums) {
        if(nums==null||nums.length==0){
            return null;
        }
        int[] results = new int[nums.length];
        //初始化结果数组
        results[nums.length-1] = 1;
        for(int i=nums.length-2;i>=0;i--){
            results[i] = results[i+1]*nums[i+1];
        }
        int temp = 1;
        for(int i=0;i<nums.length;i++){
            results[i] = results[i]*temp;
            temp = temp*nums[i];
        }
        return results;
    }
}
