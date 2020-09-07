package hot100.exercies0000.sort;

import java.util.Arrays;

/**
 * 插入排序的实现
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] nums = {3,2,5,1,8,4,7,9,6};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
    private static void sort(int[] nums){
        int temp;
        for(int i=1;i<nums.length;i++){
            for(int j=i-1,k=i;j>=0;k--,j--){
                if(nums[k]<nums[j]){
                    temp = nums[k];
                    nums[k] = nums[j];
                    nums[j] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
