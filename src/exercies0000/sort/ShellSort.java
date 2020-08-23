package exercies0000.sort;

import java.util.Arrays;

/**
 * 希尔排序的实现
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] nums = {3,2,5,1,8,4,7,9,6};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 希尔排序的实现
     * 首先将数组分成nums.length/2组，每组有之多两个元素，将每组的元素进行插入排序（其实就是交换位置）
     * 待上一轮排序之后，在将数组分为nums.length/2/2组，再进行插入排序，
     * 最后数组会被分成1组，然后进行插入排序。
     * 这样做的好处是能够将较小的数从数组的后面快速的移动到数组的前面，有效减少较小元素的比较次数
     * @param nums
     */
    private static void sort(int[] nums){
        int temp;
        for(int i=nums.length/2;i>=1;i /=2){
            for(int j=0;j<nums.length;j++){
                for(int k=j-i;k>=0;k -= i){
                    if(nums[k]>nums[k+i]){
                        temp = nums[k];
                        nums[k] = nums[k+i];
                        nums[k+i] = temp;
                    }
                }
            }
        }
    }
}
