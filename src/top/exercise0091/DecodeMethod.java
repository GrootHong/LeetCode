package top.exercise0091;

/*
一条包含字母 A-Z 的消息通过以下方式进行了编码：
'A' -> 1
'B' -> 2
...
'Z' -> 26
给定一个只包含数字的非空字符串，请计算解码方法的总数。
示例 1:
输入: "12"
输出: 2
解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
示例 2:
输入: "226"
输出: 3
解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。

227
2 22 227
272
2 27 272
 */

/**
 * 思路：
 * 回溯，超时
 * 动态规划可行吗？
 */
public class DecodeMethod {
    public static void main(String[] args) {
        DecodeMethod d = new DecodeMethod();
        int count = d.numDecodings("10");
        System.out.print(count);
    }
    private int count = 0;
    private String string;
    public int numDecodings(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        this.string = s;
        recursion(0);
        return count;
    }
    private void recursion(int index){
        if(index>=string.length()){
            count += 1;
            return;
        }
        int temp1 = Integer.parseInt(string.substring(index,index+1));
        if(temp1>0&&temp1<=9){
            recursion(index+1);
        }
        if(index<=string.length()-2){
            int temp2 = Integer.parseInt(string.substring(index,index+2));
            if(temp2>9&&temp2<=26){
                recursion(index+2);
            }
        }
    }
}
