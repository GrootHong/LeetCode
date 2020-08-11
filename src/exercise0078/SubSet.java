package exercise0078;

/*
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
说明：解集不能包含重复的子集。
示例:
输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.List;

/**
 * 思路：
 * 集合的所有子集就是集合中每个元素是否存在在子集中，所以一共会有2^n个子集。
 * 如果能够从头遍历数组，每次数组中的元素都存在在与不在两个状态，那么所有的情况就是所有的子集。
 * 步骤：
 * 1.定义一个指针，指向当前遍历到的位置，
 * 2.在每次遍历到的位置，都有两种操作，
 * 3.一是，当前元素放在子集中，
 * 4.二是，当前元素不在子集中。
 * 5.不管当前元素是否放在子集中，都将继续遍历下一位，直到遍历完所有元素，将子集放进总集合中。
 */
public class SubSet {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        SubSet s = new SubSet();
        List<List<Integer>> lists = s.subsets(nums);
        System.out.println(lists);
    }
    private List<List<Integer>> lists  = new ArrayList<>();
    private List<Integer> list  =new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums==null||nums.length==0){
            List<Integer> lst = new ArrayList<>();
            lists.add(lst);
            return lists;
        }
        recursion(nums,0);
        return lists;
    }

    private void recursion(int[] nums,int index){
        if(index==nums.length){
            List<Integer> lst = new ArrayList<>();
            for(int i=0;i<list.size();i++){
                lst.add(list.get(i));
            }
            lists.add(lst);
            return;
        }
        //当没有遍历到数组最后，就分两种情况遍历
        //首先将当前数加入list集合
        list.add(nums[index]);
        //然后递归下一个位置
        recursion(nums,index+1);
        //当上一层递归结束时，将list中最后一个删除
        list.remove(list.size()-1);
        //然后直接递归下一位
        recursion(nums,index+1);
    }
}
