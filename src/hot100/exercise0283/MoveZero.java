package hot100.exercise0283;

/*
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
示例:
输入: [0,1,0,3,12]
输出: [1,3,12,0,0]

要求
必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数
 */

/**
 * 思路：
 * 要保证非零元素的相对顺序：
 * 定义两个指针，一个指向当前指针后面的第一个0元素位置，另一个指针当前指针后面的第一个非零元素
 * 交换两个元素的值，然后将两个指针向下一位移动，直到遍历完整个数组
 */
public class MoveZero {

    public static void main(String[] args) {
        int[] nums = {1,0,1};
        MoveZero m = new MoveZero();
        m.moveZeroes(nums);
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int index = 0;
        //先将不为0得数全部移动到数组前端
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        //然后将数组得剩余部分全部补0
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}






