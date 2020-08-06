package exercise0026;

/*
给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
示例 2:
给定 nums = [0,0,1,1,1,2,2,3,3,4],
函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
你不需要考虑数组中超出新长度后面的元素。
 */

/**
 * 思路：
 * 不能创建新数组，在原来的数组基础上进行修改。
 * 因为是排序数组，所以相同的数都将在一个连续的位置上。
 * 从头开始遍历数组，用一个变量记录上一个位置数的索引，如果当前位置的数与上一个数相同，就遍历下一个，
 * 一直遍历到当前数与上一个数不同时，将上一个数索引的下一个索引处的值设置为当前值，将上一个数索引更新为刚刚设置的索引，
 * 当遍历数组，将遍历的索引+1返回即可。此时，数组中从0到索引出的值就是不重复的所有值。
 */
public class DeleteRepeat {

    public static void main(String[] args) {
        int[] array = {1,1,2,2,3,4,4,5,5,5,6};
        int[] array2 = {};
        DeleteRepeat d = new DeleteRepeat();
        int num = d.removeDuplicates(array2);
        System.out.println(num);
    }

    public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int index = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[index]!=nums[i]){
                nums[++index] = nums[i];
            }
        }
        return index+1;
    }
}
