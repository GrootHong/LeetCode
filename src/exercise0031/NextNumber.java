package exercise0031;

/*
实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
必须原地修改，只允许使用额外常数空间。
以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */

import java.util.Arrays;

/**
 * 思路：
 * 使用一个指针，从序列的最后开始向前移动，找到第一个比后面的数字大的数，
 * 然后将两个数交换， 交换后，将指针后面的数翻转即可。
 * 如果找不到上述的情况，说明当前这个数最大，将这个数翻转即可
 */
public class NextNumber {

    public static void main(String[] args) {
        int[] nums = {1,3,5,4,2};
        NextNumber n = new NextNumber();
        n.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void nextPermutation(int[] nums) {
        int index = nums.length-1;
        while(index>=0){
            if(index-1>=0&&nums[index-1]<nums[index]){
                //交换nums[index-1]和index后面的第一个大与nums[index-1]的数交换
                int pos = index;
                for(int i=index;i<nums.length;i++){
                    if(nums[index-1]<=nums[i])
                    {
                        pos = i;
                    }
                }
                int temp = nums[index-1];
                nums[index-1] = nums[pos];
                nums[pos] = temp;
                //然后将从指针位置到数组结束的所有元素翻转
                reverse(nums,index,nums.length-1);
                break;
            } else if(index==0){
                reverse(nums,0,nums.length-1);
                break;
            }
            index--;
        }
    }

    /**
     * 翻转数组中指定位置的数
     * @param nums 数组
     * @param start 翻转开始位置
     * @param end 翻转结束位置
     */
    private void reverse(int[] nums,int start,int end){
        if(start>=end||end>=nums.length){
            return;
        }
        int temp;
        while (start<end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
