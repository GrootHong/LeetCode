package hot100.exercise0049;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
示例:
输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：
所有输入均为小写字母。
不考虑答案输出的顺序。
 */
/**
 * 思路：
 * 遍历字符串数组，对每个遍历到的字符串，将其按字典顺序重组，然后在集合中遍历，如果有相同的就添加进那个子集合中，
 * 如果没有相同的就再创建一个新的子集合存放，遍历完结束
 *
 * lst集合完全可以用一个map实现，因为要保证key唯一，为何不用java原有的，而非要自己实现呢？
 */
public class LettersGroup {

    public static void main(String[] args) {
        String[] s = {"",""};
        LettersGroup l = new LettersGroup();
        List<List<String>> lists = l.groupAnagrams(s);
        System.out.println(lists);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        if(strs==null||strs.length==0){
            return lists;
        }
        List<char[]> lst = new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            char[] chs = strs[i].toCharArray();
            Arrays.sort(chs);
            //判断lst集合中是否有chs
            int index = contain(lst,chs);
            if(index!=-1){
                lists.get(index).add(strs[i]);
            } else {
                lst.add(chs);
                List<String> l = new ArrayList<>();
                l.add(strs[i]);
                lists.add(l);
            }
        }
        return lists;
    }
    private int contain(List<char[]> list,char[] chs){
        for(int j=0;j<list.size();j++){
            if(chs.length!=0){
                for(int i=0;i<list.get(j).length&&i<chs.length;i++){
                    if(chs[i]!=list.get(j)[i]){
                        break;
                    }
                    if(i==list.get(j).length-1&&i==chs.length-1&&list.get(j)[i]==chs[i]){
                        return j;
                    }
                }
            } else {
                if(list.get(j).length==0){
                    return j;
                }
            }
        }
        return -1;
    }



}
