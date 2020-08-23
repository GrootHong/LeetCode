package exercies0000.sort;

import java.util.Arrays;

/**
 * 选择排序实现
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] nums = {3,2,5,1,8,4,7,9,6};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 选择排序，每次从数组中找出最小元素，与数组最前面元素交换
     * 一共会发生n-1论交换。
     * @param nums 输入数组
     */
    private static void sort(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            int minIndex = i;
            for(int j=i+1;j<nums.length;j++){
                if(nums[minIndex]>nums[j]){
                    minIndex = j;
                }
            }
            int min = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = min;
        }
    }
}
