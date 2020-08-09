package exercise0017;

/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 思路：
 * 1.首先使用map集合将每个数字对应的字母映射起来，
 * 2.然后对传入的字符串进行分解，其实就是对字符串的首个数字进行操作，
 * 3.然后找到对应的字母选一个，
 * 4.然后将剩下的字符串进行递归操作。
 * 5.当退出递归时，应该将该层递归中确定的字母剔除。
 */
public class CharacterArray {

    public static void main(String[] args) {
        String s = "239";
        CharacterArray c = new CharacterArray();
        System.out.println(c.letterCombinations(s));
    }
    private List<String> list = new LinkedList<>();
    private StringBuilder sb = new StringBuilder();
    private Map<Character,String> map = new HashMap<Character, String>();
    {
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
    }
    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0){
            return list;
        }
        recursion(digits);
        return list;
    }
    private void recursion(String s){
        //判断字符串是否为空串，是空串就向集合中添加一个
        if(s.length()==0){
            list.add(sb.toString());
            return;
        }
        //首先获得第一位对应的字母
        String str = map.get(s.charAt(0));
        for(int i=0;i<str.length();i++){
            sb.append(str.substring(i,i+1));
            recursion(s.substring(1));
            //退出一层递归，删除最后一个字母
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
