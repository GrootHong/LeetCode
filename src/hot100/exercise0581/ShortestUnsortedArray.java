package hot100.exercise0581;

/*

给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
你找到的子数组应是最短的，请输出它的长度。

示例 1:
输入: [2, 6, 4, 8, 10, 9, 15]
输出: 5
解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。

说明 :
输入的数组长度范围在 [1, 10,000]。
输入的数组可能包含重复元素 ，所以升序的意思是<=。
 */

/**
 * 思路：
 * 正序遍历数组，当数组中出现降序排列时，记录下此时的数字min。并继续向后遍历找到最小值，
 * 逆序遍历数组，当数组中出现升序排列时，记录下此时的数字max，并继续向前遍历找到最大值
 * 正序遍历，确定最小值的位置，逆序遍历，确定最大值的位置
 */
public class ShortestUnsortedArray {

    public int findUnsortedSubarray(int[] nums) {
        int min = 0;
        int max = 0;
        //确定最小数
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        //确定最大数
        for (int i = nums.length - 1; i >= 0; i--) {
            if(nums[i]>max){
                max = nums[i];
            }
        }
        //确定最小值的位置
        int minIndex = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>min){
                minIndex = i;
                break;
            }
        }
        //确定最大值位置
        int maxIndex = nums.length-1;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]<max){
                maxIndex = i;
                break;
            }
        }
        return maxIndex-minIndex+1;
    }
}
