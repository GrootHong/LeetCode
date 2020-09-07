package hot100.exercise0136;

/*
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
说明：
你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */

/**
 * 思路：
 * 刚开始看见均出现两次，就觉得很有用，但是没有仔细想
 * 看了评论才突然想起，位运算怎么就没想到呢，两个相同的数字异或运算结果为0.
 * 所以将数组中所有数字抑或一遍，结果就是那个单独的数。
 */
public class FindUniqueNumber {
    public int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }
}
