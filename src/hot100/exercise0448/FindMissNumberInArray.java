package hot100.exercise0448;

/*
给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
找到所有在 [1, n] 范围之间没有出现在数组中的数字。
您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
示例:
输入:
[4,3,2,7,8,2,3,1]
输出:
[5,6]
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 思路：
 * 思路清奇，遍历数组，将遍历到得值对应得第几个索引上的值置为负数，并且在遍历数组时对遍历到得值取绝对值，
 * 最后剩下得没有被设置为负数得值得位置就是数组中缺少得数
 */
public class FindMissNumberInArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int temp = Math.abs(nums[i]);
            nums[temp-1] = -Math.abs(nums[temp-1]);
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                list.add(i+1);
            }
        }
        return list;
    }
}
