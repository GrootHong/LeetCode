package exercise0022;

import java.util.ArrayList;
import java.util.List;

/*
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
示例：
输入：n = 3
输出：[
       "((()))",
       "(()())",
       "(())()",
       "()(())",
       "()()()"
     ]
 */

/**
 * 思路1：
 * 先将这n对括号全排列，然后在这些全排列里找有效的组合。
 * 会有重复的出现，排除此方法。
 *
 * 思路2：
 *
 */
public class CreateBrackets {
    public static void main(String[] args) {
        int num = 0;
        CreateBrackets c = new CreateBrackets();
        List<String> list = c.generateParenthesis(num);
        System.out.println(list);
    }
    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        int left = n;
        int right = n;
        String s = "";
        recursion(n,n,s);
        return list;
    }

    private void recursion(int left,int right,String s){
        if(left!=0&&right==0){
            return;
        }
        else if(left!=0&&right!=0){
            s += "(";
            recursion(left-1,right,s);
            s = s.substring(0,s.length()-1);
            s += ")";
            recursion(left,right-1,s);
        }
        else if(left==0&&right!=0){
            s += ")";
            recursion(left,right-1,s);
        } else {
            if(isSatisfy(s)){
                list.add(s);
            }
        }
    }
    private boolean isSatisfy(String s){
        String str = s;
        for(int i=0;i<s.length()/2;i++){
            str = str.replace("()","");
        }
        return str.length()==0?true:false;
    }

}
