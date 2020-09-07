package hot100.exercies0000.sort;

import java.util.Arrays;

/**
 * 冒泡排序实现
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {3,2,5,1,8,4,7,9,6};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 每一趟循环，就将数组中的最大值移到最后，
     * 每一趟循环内，又是一个小的循环，是将大数慢慢向后移动。
     * @param nums
     */
    private static void sort(int[] nums){
        int temp;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]>nums[j]){
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
