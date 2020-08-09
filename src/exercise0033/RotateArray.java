package exercise0033;

/*
假设按照升序排序的数组在预先未知的某个点上进行了旋转。
( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
你可以假设数组中不存在重复的元素。
你的算法时间复杂度必须是 O(log n) 级别。
示例 1:
输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
示例 2:
输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1
 */

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * 思路：
 * 直接二分，如果中间数大于目标值
 * 如果中间值前面的值比中间值小，向前寻找
 * 如果中间值前面的值比中间值大，不存在。
 * 如果中间数小于目标值
 * 如果中间值前面的值比中间值小，向后寻找
 * 如果中间值前面的值比中间值大，则判断数组第一个数与目标值关系，确定在哪一部分查找
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] a =  {4,5,6,7,0,1,2};
        RotateArray r = new RotateArray();
        int n = r.search(a,6);
        System.out.println(n);
    }

    public int search(int[] nums, int target) {
        int len = nums.length;
        if(len==0){
            return -1;
        }
        return search(nums, 0, len - 1, target);
    }

    private int search(int[] nums, int left, int right, int target) {
        if (left == right && nums[left] == target) {
            return left;
        } else if (left == right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        //从中间到最后是排序的，且target在这中间
        if (target > nums[mid] && target <= nums[right]) {
            return search(nums, mid + 1, right, target);
        }
        //从开始到中间是排序的，且target在这中间
        else if (target >= nums[left] && target <= nums[mid]) {
            return search(nums, left, mid, target);
        }
        //剩下两种情况，从开始到中间不排序，且目标在其中
        else if (nums[mid] < nums[right]) {
            return search(nums, left, mid, target);
        }
        //从中间到最后不排序，目标在其中
        else {
            return search(nums, mid + 1, right, target);
        }
    }
}
