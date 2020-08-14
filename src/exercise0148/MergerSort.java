package exercise0148;

import java.util.Arrays;

/**
 * 实现数组的归并排序
 * 1.将数组一分为二，
 */
public class MergerSort {
    public static void main(String[] args) {
        int[] a = {3,2,5,8,1,4,6,9,7};
        new MergerSort().mergeSort(a);
        System.out.println(Arrays.toString(a));
    }

    private void mergeSort(int[] a){
        if(a==null||a.length==0){
            return;
        }
        split(a,0,a.length-1,new int[a.length]);
    }

    private void split(int[] array,int left,int right,int[] temp){
        if(left<right){
            int mid = (left+right)/2;
            split(array,left,mid,temp);
            split(array,mid+1,right,temp);
            merge(array,left,mid,right,temp);
        }
    }

    private void merge(int[] array,int left,int mid,int right,int[] temp){
        int l = left;
        int r = mid+1;
        int t = 0;
        while(l<=mid&&r<=right){
            if(array[l]<=array[r]){
                temp[t++] = array[l++];
            } else {
                temp[t++] = array[r++];
            }
        }
        while(l<=mid){
            temp[t++] = array[l++];
        }
        while(r<=right){
            temp[t++] = array[r++];
        }
        t = 0;
        int tempLeft = left;
        while(tempLeft<=right){
            array[tempLeft++] = temp[t++];
        }
    }


}
