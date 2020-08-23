package exercies0000.sort;

import java.util.Arrays;

/**
 * 归并排序的实现
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {3,2,5,1,8,4,7,9,6};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
    private static int[] temp;
    private static int index = 0;
    private static void sort(int[] nums){
        if(nums==null||nums.length<=1){
            return;
        }
        temp = new int[nums.length];
        split(nums,0,nums.length-1);
        return;
    }
    private static void split(int[] nums,int start,int end){
        if(start==end){
            return;
        }
        int mid = (start+end)/2;
        split(nums,start,mid);
        split(nums,mid+1,end);
        merge(nums,start,mid,end);
    }
    private static void merge(int[] nums,int start,int mid,int end){
        int left = start;
        int right = mid+1;
        while(left<mid+1&&right<=end){
            if(nums[left]<nums[right]){
                temp[index++] = nums[left++];
            } else {
                temp[index++] = nums[right++];
            }
        }
        while(left<mid+1){
            temp[index++] = nums[left++];
        }
        while(right<=end){
            temp[index++] = nums[right++];
        }
        for(int i=start,k=0;i<=end;i++){
            nums[i] = temp[k++];
        }
        index = 0;
    }

}
