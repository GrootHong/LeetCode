package exercise0148;

import java.util.Arrays;

/**
 * 快速排序：
 * 首先确定范围中的中间位置，然后向前向后
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {3,2,5,8,1,4,6,9,7};
        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(int[] array,int left,int right){
        int l = left;
        int r = right;
        int midVal = array[(l+r)/2];
        while(l<r){
            while(array[l]<midVal){
                l++;
            }
            while(array[r]>midVal){
                r--;
            }
            if(l>=r){
                break;
            }
            int temp = array[l];
            array[l] = array[r];
            array[r] = temp;
            if(array[l]==midVal){
                l++;
            }
            if(array[r]==midVal){
                r--;
            }
        }
        if(l==r){
            l++;
            r--;
        }
        if(l<right){
            quickSort(array,l,right);
        }
        if(r>left){
            quickSort(array,left,r);
        }
    }
}

