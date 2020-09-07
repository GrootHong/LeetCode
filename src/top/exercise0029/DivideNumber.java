package top.exercise0029;

/*
给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
返回被除数 dividend 除以除数 divisor 得到的商。
整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
示例 1:
输入: dividend = 10, divisor = 3
输出: 3
解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
示例 2:
输入: dividend = 7, divisor = -3
输出: -2
解释: 7/-3 = truncate(-2.33333..) = -2
提示：
被除数和除数均为 32 位有符号整数。
除数不为 0。
假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。
 */

/**
 * 思路：
 * 1.首先考虑特殊情况：对于溢出的问题，只有一种情况会出现溢出，那就是最小整数除以-1，其结果本应是最大整数+1，导致溢出。
 * 2.有题意可分析到，不管怎么除，都是绝对值相除，最后加上符号就行。
 * 3.只需考虑两个正整数相除。
 * 4.如果被除数小于除数，直接返回0，
 * 5.如果被除数大于除数，开始进行递归除法。
 * 5.1定义一个变量res接收商，因为被除数大于除数，所以res首先置为1.
 * 5.2将除数翻倍，然后递归该方法，如果返回值为0，进入5.3，如果返回值不为0，直接返回结果。
 * 5.3将被除数减去除数，res+1；
 */
public class DivideNumber {
    public static void main(String[] args) {
        DivideNumber divideNumber = new DivideNumber();
        int divide = divideNumber.divide(-2147483648,2);
        System.out.println(divide);
    }

    public int divide(int dividend, int divisor) {
        if(divisor==1){
            return dividend;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean flag = true;//存储计算结果是正数还是负数，true为正
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            flag = false;
        }
        int res = div(Math.abs((long)dividend), Math.abs((long)divisor));
        return flag ? res : -res;
    }

    /**
     * 将两个正数相除
     * @param dividend 被除数
     * @param divisor 除数
     * @return 商
     */
    private int div(long dividend,long divisor){
        if(dividend<divisor){
            return 0;
        }
        int res = 1;
        long temp = divisor;//固定divisor不动，每次递归时从头开始递归，只是被除数在慢慢减小。
        while((temp+temp)<dividend&&temp+temp>0){
            res += res;
            temp += temp;
        }
        return res + div(dividend-temp,divisor);
    }

}











