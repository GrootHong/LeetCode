package hot100.exercise0003;

/*
题目3：
给定一个字符串，请你找出其中不含有重复字符的 最长子串的长度
 */

import java.util.Arrays;

/**
 * 思路：
 * 定义一个256长度的int数组，每个索引值对应ascii码中对应的字符，
 * 定义一个变量，记录当前最长不重复子串长度，定义一个变量，记录历史最长不重复子串长度
 * 遍历字符串，对于每个遍历到的字符，判断是否出现过，如果出现过，计算上次出现到当前位置间的距离
 * 如果没有出现过或者距离大于当前不重复最长子串长度，则不用管，
 * 如果距离小于等于当前最长子串长度，则更改当前子串长度为距离
 * 将数组中当前字符对应位置的值改为当前字符串索引，遍历下一位
 */
public class MaxStringWithNoRepeat {

    public static void main(String[] args) {
        MaxStringWithNoRepeat m = new MaxStringWithNoRepeat();
        String string = "abcabcbb";
        int num = m.lengthOfLongestSubstring(string);
        System.out.println(num);
    }

    public int lengthOfLongestSubstring(String s) {
        //判空
        if (s == null || s.length() == 0) {
            return 0;
        }
        //字符串不为空
        int[] index = new int[256];
        Arrays.fill(index, -1);
        int curLength = 0;
        int maxLenght = 0;
        //开始遍历字符串
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            //判断数组中是否出现过
            if(index[ch]==-1){
                //没有出现过
                curLength++;
            } else {
                //出现过，则比较距离与curLen的关系
                int len = i-index[ch];
                if(len<=curLength){
                    //距离小于等于curLength
                    curLength = len;
                } else {
                   curLength++;
                }
            }
            //比较curLength与maxLength的关系
            if(curLength>maxLenght){
                maxLenght = curLength;
            }
            //将当前位置的值设置为字符串索引
            index[ch] = i;
        }
        return maxLenght;
    }
}
