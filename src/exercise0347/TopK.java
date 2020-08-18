package exercise0347;

/*
给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
示例 1:
输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:
输入: nums = [1], k = 1
输出: [1]
提示：
你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
你可以按任意顺序返回答案。
 */

import java.util.*;

/**
 * 思路：
 * 排序后再遍历的时间复杂度为O(nlogn),也就是说，明确规定不能排序后再算
 * 所以只能在一趟遍历中完成整个数的计算。
 * 由于对空间没有明确限制，可以使用hashMap来记录每个值出现的次数
 * 因此空间复杂度为O(n)，时间复杂度为O(n)
 */
public class TopK {
    public static void main(String[] args) {
        int[] nums = {-1,-1};
        TopK t = new TopK();
        int[] res = t.topKFrequent(nums,1);
        System.out.println(Arrays.toString(res));
    }
    public int[] topKFrequent(int[] nums, int k) {
        if(nums==null||nums.length==0){
            return null;
        }
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])==null){
                map.put(nums[i],1);
            } else {
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        //相当于可以将出现对次数的值添加在前面，出现次数少次数的值添加在后面
        //这样在弹出的时候，前面的数一直都是出现频率最高的。
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        // 取出最小堆中的元素
        int[] res = new int[k];
        int index = 0;
        while (!pq.isEmpty()) {
            res[index++] = pq.remove();
        }
        return res;
    }
}
