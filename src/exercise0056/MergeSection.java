package exercise0056;

/*
给出一个区间的集合，请合并所有重叠的区间。
示例 1:
输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:
输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */

/**
 * 思路：
 * 定义两个遍历记录左端点和右端点
 * 遍历二维数组的每一行，每一行中第一个数为左端点，第二个数为右端点
 * 当遍历到的左端点小于记录的右端点，就将记录的右端点改为两个右端点中较大的一个
 * 当遍历到的左端点大于保存的右端点，就重新开辟空间保存。
 */
public class MergeSection {

    public static void main(String[] args) {

    }
    public int[][] merge(int[][] intervals) {
        return null;
    }
}
