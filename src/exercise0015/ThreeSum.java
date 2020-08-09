package exercise0015;

/*
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
注意：答案中不可以包含重复的三元组。
示例：
给定数组 nums = [-1, 0, 1, 2, -1, -4]，
满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 思路：
 * 首先将数组升序排序，然后确定数组中最后一个负数，0，第一个正数的位置
 * 然后首先在负数范围内确定一个数，如果在正数范围内能够找到两个数相加对应，就是一种解法。
 * 再在正数范围内确定一个数，如果能够找到两个负数与之对应，就又是一种解法
 * 最后，再正数范围内确定一个数，确定一个0，在负数范围内确定一个数，又是一种解法
 * 最最后，在0中确定3个0，是最后一种解法。
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] a = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        ThreeSum t = new ThreeSum();
        List<List<Integer>> lists = t.threeSum(a);
        System.out.println(lists);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return lists;
        }
        //首先将数组排序
        Arrays.sort(nums);
        //然后确定最后一个负数的位置
        int lastNegative = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                if (i != 0) {
                    lastNegative = i - 1;
                }
                break;
            }
        }
        //确定第一个正数的位置
        int firstPositive = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                firstPositive = i;
                break;
            }
        }
        //没有负数或者正数
        if (lastNegative == -1 || firstPositive == -1) {
            //既没有负数，也没有正数
            if (lastNegative == -1 && firstPositive == -1) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(0);
                list.add(0);
                list.add(0);
                lists.add(list);
                return lists;
            }
            //没有负数，0足够
            else if (lastNegative == -1 && firstPositive >= 3) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(0);
                list.add(0);
                list.add(0);
                lists.add(list);
                return lists;
            }
            //没有正数，0足够
            else if (firstPositive == -1 && lastNegative < nums.length - 3) {
                ArrayList<Integer> list = new ArrayList<>(3);
                list.add(0);
                list.add(0);
                list.add(0);
                lists.add(list);
                return lists;
            } else {
                return lists;
            }
        }
        //在负数中确定一个数
        for (int i = 0; i <= lastNegative; i++) {
            for (int j = firstPositive; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (i != 0) {
                        if (nums[i] != nums[i - 1]&&nums[j]!=nums[j-1] && nums[i] + nums[j] + nums[k] == 0) {
                            ArrayList<Integer> list = new ArrayList<>(3);
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            lists.add(list);
                            break ;
                        }
                    } else {
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            ArrayList<Integer> list = new ArrayList<>(3);
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            lists.add(list);
                            break ;
                        }
                    }

                }
            }
        }
        //在正数中确定一个数
        for (int i = firstPositive; i < nums.length; i++) {
            for (int j = 0; j < lastNegative; j++) {
                for (int k = j + 1; k <= lastNegative; k++) {
                    if (i != 0) {
                        if (nums[i] != nums[i - 1]&&nums[j]!=nums[j-1]  && nums[i] + nums[j] + nums[k] == 0) {
                            ArrayList<Integer> list = new ArrayList<>(3);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(nums[i]);
                            lists.add(list);
                            break ;
                        }
                    } else {
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            ArrayList<Integer> list = new ArrayList<>(3);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(nums[i]);
                            lists.add(list);
                            break ;
                        }
                    }
                }
            }
        }
        //如果有0存在
        if (firstPositive - lastNegative >= 2) {
            for (int i = 0; i <= lastNegative; i++) {
                for (int j = firstPositive; j < nums.length; j++) {
                    if (i != 0) {
                        if (nums[i] != nums[i - 1] && nums[i] + nums[j] == 0) {
                            ArrayList<Integer> list = new ArrayList<>(3);
                            list.add(nums[i]);
                            list.add(0);
                            list.add(nums[j]);
                            lists.add(list);
                            break;
                        }
                    } else {
                        if (nums[i] + nums[j] == 0) {
                            ArrayList<Integer> list = new ArrayList<>(3);
                            list.add(nums[i]);
                            list.add(0);
                            list.add(nums[j]);
                            lists.add(list);
                            break;
                        }
                    }

                }
            }
        }
        //如果有大于等于3个0存在
        if (firstPositive - lastNegative >= 4) {
            ArrayList<Integer> list = new ArrayList<>(3);
            list.add(0);
            list.add(0);
            list.add(0);
            lists.add(list);
        }
        return lists;
    }
}
