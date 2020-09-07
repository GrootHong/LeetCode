package hot100.exercise0287;

/*
给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
示例 1:
输入: [1,3,4,2,2]
输出: 2
示例 2:
输入: [3,1,3,4,2]
输出: 3
说明：
不能更改原数组（假设数组是只读的）。
只能使用额外的 O(1) 的空间。
时间复杂度小于 O(n2) 。
数组中只有一个重复的数字，但它可能不止重复出现一次。
 */

/**
 * 思路：
 * 数组只读，不能使用额外空间, 所以不能排序。
 * 时间复杂度小于O(n^2), 所以嵌套查找不行。
 * 等效成链表是否存在环的问题？
 * 定义快慢指针，都从数组头运动，每次运动到数组中值对应的索引位置，快指针每次移动两次，慢指针每次移动一格。
 * 当两者最终相等时，说明存在重复元素，并且重复元素就是相等时位置的值
 */
public class FindRepeatNumber {
    public static void main(String[] args) {
        int[] nums = {2,5,9,6,9,3,8,9,7,1};
        FindRepeatNumber f = new FindRepeatNumber();
        System.out.println(f.findDuplicate(nums));
    }
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
