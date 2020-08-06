package exercise0020;

/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
有效字符串需满足：
    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
    注意空字符串可被认为是有效字符串。
示例 2:
    输入: "()[]{}"
    输出: true
示例 4:
    输入: "([)]"
    输出: false
 */

import java.util.Stack;

/**
 * 思路：
 * 在输入的字符串中，去掉空格之后，如果字符串是有效的，那么一定至少有一处的括号是连续出现的。
 * 那么将这对连续出现的括号用“”替换，一直替换，最终的字符串将是空串，此时返回true
 * 如果循环一定次数后，字符串还不为空，则字符串一定不是有效的，返回false。
 */
public class ValiableBrackets {

    public static void main(String[] args) {
        String string = "({)}";
        ValiableBrackets v = new ValiableBrackets();
        boolean flag = v.isValid2(string);
        System.out.println(flag);
    }

    public boolean isValid2(String s) {
        //新建一个栈，当遇到(,[,{时就往栈中压入与之对应的右括号，当
        //当遇到其他字符时，就从栈中弹出一个字符，如果两个字符不一样或者栈空，就返回否
        //当遍历完整个字符串，栈空，则返回true，否则返回false
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch=='('){
                stack.push(')');
            } else if(ch=='['){
                stack.push(']');
            } else if(ch=='{'){
                stack.push('}');
            } else if(stack.empty()||ch!=stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid(String s) {
        //先将字符串中的空格替换为""
        s = s.replaceAll(" ","");
        //定义一个变量记录上一次替换后的字符串
        //然后计算最小循环次数，这个次数就是替换后字符串长度除以2
        int count = s.length()/2;
        for(int i=0;i<count;i++){
            if(s.length()!=0){
                if(s.contains("()")||s.contains("[]")||s.contains("{}")){
                    s = s.replaceAll("\\(\\)|\\[\\]|\\{\\}" ,"");
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }
        if(s.length()==0){
            return true;
        }
        return false;
    }
}
