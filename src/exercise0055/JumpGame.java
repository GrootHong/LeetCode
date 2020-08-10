package exercise0055;

/*
给定一个非负整数数组，你最初位于数组的第一个位置。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个位置。
示例 1:
输入: [2,3,1,1,4]
输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
示例 2:
输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */

/**
 * 思路：
 * 定义一个指针指向数组的最后一位，然后将指针向前遍历，
 * 每遍历到一位，就比较这一位能否到达最后一位，如果能，返回递归结果，
 * 如果不能，继续向前遍历，
 * 当遍历完整个数组时，如果都不能到达，就返回false；
 */
public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        JumpGame j = new JumpGame();
        boolean flag = j.canJump(nums);
        System.out.println(flag);
    }
    public boolean canJump(int[] nums) {
        if(nums==null||nums.length==0){
            return false;
        }
        return recursion(nums,nums.length-1);
    }

    private boolean recursion(int[] nums,int cur){
        if(cur<0){
            return false;
        }
        if(cur==0){
            return true;
        }
        for(int i=cur-1;i>=0;i--){
            if(nums[i]>=cur-i){
                return recursion(nums,i);
            }
        }
        return false;
    }
}
