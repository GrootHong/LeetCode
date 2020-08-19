package exercise0406;

/*
假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，
其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
注意：
总人数少于1100人。
示例
输入:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
输出:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */

import java.util.*;

/**
 * 思路：
 * 将传入的数组重现排序，按照第一个值降序，第二个值升序排列，
 * 然后遍历一遍数组，将不符合的值重新插入。
 */
public class RebuildQueue {

    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        RebuildQueue r = new RebuildQueue();
        int[][] res = r.reconstructQueue(people);
        System.out.println(res);
    }
    public int[][] reconstructQueue(int[][] people) {
        if(people==null||people.length==0||people[0].length==0){
            return people;
        }
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<people.length;i++){
            list.add(people[i]);
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]){
                    return o2[0] - o1[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        //遍历集合，将对应位置插入正确的值
        for(int i=0;i<list.size();i++){
            if(i>list.get(i)[1]){
                list.add(list.get(i)[1],list.remove(i));
            }
        }

        int[][] res = new int[people.length][people[0].length];
        for(int i=0;i<people.length;i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
