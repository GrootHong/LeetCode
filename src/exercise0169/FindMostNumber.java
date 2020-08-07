package exercise0169;

/*
给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */

/**
 * 思路：
 * 定义一个数记录目前出现最多的数，再定义一个计数器，记录这个数出现的次数，
 * 当再次出现这个数时，计数器加一，当出现的不是这个数，计数器减一，
 * 当计数器为0时，更新这个数。
 * 遍历完整个数组，最后保存的这个数就是结果
 */
public class FindMostNumber {
    public static void main(String[] args) {
        int[] array = {2,2,1,1,1,2,2};
        FindMostNumber f = new FindMostNumber();
        int num = f.majorityElement(array);
        System.out.println(num);
    }

    public int majorityElement(int[] nums) {
        int num = nums[0];
        int count =1;
        for(int i=1;i<nums.length;i++){
            if(num!=nums[i]){
                if(count>0){
                    count--;
                } else {
                    num = nums[i];
                    count = 1;
                }
            } else {
                count++;
            }
        }
        return num;
    }
}
