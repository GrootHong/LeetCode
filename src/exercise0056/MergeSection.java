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

import com.sun.security.ntlm.Client;
import oracle.jrockit.jfr.parser.FLREventInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 思路：
 * 1.首先将二维数组每行按照大小升序排序，并且定义两个遍历记录左端点和右端点
 * 2.然后从头到尾遍历每个区间，
 * 3.当遍历到的左端点小于保存的右端点，则将右端点更改为两个右端点中较大的那个
 * 4.当遍历到的左端点大于保存的有端点，则将保存的左右端点保存进集合，重新设置左右端点。
 * 5.最后遍历完成，将最后的最右端点保存进集合。
 */
public class MergeSection {

    public static void main(String[] args) {
        int[][] a = {{1,3},{2,6},{8,10},{9,18}};
        MergeSection m = new MergeSection();
        int[][] n = m.merge(a);
        System.out.println(Arrays.toString(n));
    }
    public int[][] merge(int[][] intervals) {
        if(intervals==null||intervals.length==0||intervals[0].length==0){
            return new int[0][0];
        }
        List<int[]> lists = new ArrayList<>();
        //开始排序
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            list.add(intervals[i]);
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]>o2[0]){
                    return 1;
                } else if(o1[0]<o2[0]){
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        //开始合并
        int left = list.get(0)[0];
        int right = list.get(0)[1];
        for(int i=1;i<list.size();i++){
            if(list.get(i)[0]<=right){
                if(left>list.get(i)[0]){
                    left = list.get(i)[0];
                }
                if(right< list.get(i)[1]){
                    right = list.get(i)[1];
                }
            } else {
                lists.add(new int[]{left,right});
                left = list.get(i)[0];
                right = list.get(i)[1];
            }
        }
        lists.add(new int[]{left,right});
        int[][] res = new int[lists.size()][2];
        for(int i=0;i<lists.size();i++){
            res[i] = lists.get(i);
        }
        return res;
    }

}
