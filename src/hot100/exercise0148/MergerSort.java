package hot100.exercise0148;

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

    private void mergeSort(int[] array){
        if(array==null||array.length<=1){
            return;
        }
        int[] temp = new int[array.length];
        split(array,0,array.length-1,temp);
    }

    private void split(int[] array,int start, int end, int[] temp){
        if(start<end){
            int mid = (start+end)/2;
            split(array,start,mid,temp);
            split(array,mid+1,end,temp);
            merge(array,start,mid,end,temp);
        }
    }
    private void merge(int[] array,int start,int mid,int end,int[] temp){
        int left = start;
        int right = mid+1;
        int index = 0;
        while(left<=mid&&right<=end){
            if(array[left]<array[right]){
                temp[index++] = array[left++];
            } else {
                temp[index++] = array[right++];
            }
        }
        if(left<=mid){
            for(int i=left;i<=mid;i++){
                temp[index++] = array[i];
            }
        }
        if(right<=end){
            for(int i=right;i<=end;i++){
                temp[index++] = array[i];
            }
        }
        int tempIndex = start;
        for(int i = 0;i<index;i++){
            array[tempIndex++] = temp[i];
        }
    }
}
