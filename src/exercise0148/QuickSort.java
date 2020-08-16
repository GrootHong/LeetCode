package exercise0148;

import java.util.Arrays;

/**
 * 快速排序：
 * 首先确定范围中的中间位置，然后向前向后
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {3,2,5,8,1,4,6,9,7};
        quickSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(int[] array){
        if(array==null||array.length<=1){
            return;
        }
        quickSort(array,0,array.length-1);
    }
    private static void quickSort(int[] array,int start,int end){
        int left = start;
        int right = end;
        int midVal = array[(left+right)/2];
        while(left<right){
            while(array[left]<midVal){
                left++;
            }
            while(array[right]>midVal){
                right--;
            }
            if(left>=right){
                break;
            }
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
        if(left==right){
            left++;
            right--;
        }
        //尾递归，是不是可以换成循环方式
        if(left<end){
            quickSort(array,left,end);
        }
        if(right>start){
            quickSort(array,start,right);
        }
    }

}

