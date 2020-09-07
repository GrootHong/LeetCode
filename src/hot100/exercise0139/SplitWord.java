package hot100.exercise0139;

import java.util.ArrayList;
import java.util.List;

/*
给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
说明：
拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
示例 1：
输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
示例 2：
输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     注意你可以重复使用字典中的单词。
示例 3：
输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false
 */

/**
 * 思路：
 * 1.遍历给定的字典数组，每遍历到一个，就与给定字符串的开头进行比较，
 * 2.如果相同，就截取字符串，然后进行递归，
 * 3.如果不相同，就退出递归，退出前将截取的字符串还原。
 * 4.当字符串长度为0时，说明能切割。
 *
 *
 * 花费时间太长，使用动态规划算法解决
 */
public class SplitWord{

    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        SplitWord sw = new SplitWord();
        boolean flag = sw.wordBreak(s,wordDict);
        System.out.println(flag);
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s==null||wordDict==null||wordDict.size()==0){
            return false;
        }
        if(s.length()==0){
            return true;
        }
        for(int i=0;i<wordDict.size();i++){
            String str = wordDict.get(i);
            if(str.length()<=s.length()&&str.equals(s.substring(0,str.length()))){
                boolean flag = wordBreak(s.substring(str.length()),wordDict);
                if(flag){
                    return true;
                }
            }
        }
        return false;
    }
}
