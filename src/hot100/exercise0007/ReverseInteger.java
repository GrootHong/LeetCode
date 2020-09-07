package hot100.exercise0007;

/*
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
示例 1:
输入: 123
输出: 321
 示例 2:
输入: -123
输出: -321
示例 3:
输入: 120
输出: 21
注意:
假设我们的环境只能存储得下 32 位的有符号整数，
则其数值范围为 [−2^31,  2^31 − 1]。
请根据这个假设，如果反转后整数溢出那么就返回 0。
 */

/**
 * 思路:
 * 转成字符串
 * 然后判断正负，在判断后面是否是0.
 *
 */
public class ReverseInteger {
    public static void main(String[] args) {
        int x = -1111111119;
        ReverseInteger r = new ReverseInteger();
        int reNum = r.reverse(x);
        System.out.println(reNum);
    }
    public int reverse(int x) {
        String num = x+"";
        int start = 0,end = num.length()-1;
        if(num.startsWith("-")){
            start = 1;
        }
        for(int i=num.length()-1;i>=0;i--){
            if(num.charAt(i)!='0'){
                end = i;
                break;
            }
        }
        return reverse(num,start,end);
    }
    /**
     * 翻转字符串中的某一段
     * @param num 传入的字符串
     * @param start 待翻转的开始索引
     * @param end 待翻转的结束索引
     * @return 返回反转后的结果
     */
    private int reverse(String num,int start,int end){
        int position = end;
        char[] chs = num.toCharArray();
        while(start<end){
            char ch = chs[start];
            chs[start++] = chs[end];
            chs[end--] = ch;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<position+1;i++){
            sb.append(chs[i]);
        }
        String temp = sb.toString();
        try{
            return Integer.parseInt(temp);
        } catch(Exception e){
            return 0;
        }
    }
}
























