package exercies0000.sort;

import java.util.Arrays;

/**
 * 快速排序的实现
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {3,2,5,1,8,4,7,9,6};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 快速排序
     *
     * @param nums
     */
    private static void sort(int[] nums){
        if(nums==null||nums.length<=1){
            return;
        }
        sort(nums,0,nums.length-1);
    }
    private static void sort(int[] nums,int start,int end){
        int left = start;
        int right = end;
        int midVal = nums[(start+end)/2];
        while(left<right){
            while(nums[left]<midVal){
                left++;
            }
            while(nums[right]>midVal){
                right--;
            }
            if(left>=right){
                break;
            }
            //交换
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            if(nums[left] == midVal){
                left++;
            }
            if(nums[right]== midVal){
                right--;
            }
        }

        if(left==right){
            left++;
            right--;
        }
        if(start<right){
            sort(nums,start,right);
        }
        if(left<end){
            sort(nums,left,end);
        }
    }
}
