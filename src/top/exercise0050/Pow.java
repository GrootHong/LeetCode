package top.exercise0050;

/*
实现 pow(x, n) ，即计算 x 的 n 次幂函数。
示例 1:
输入: 2.00000, 10
输出: 1024.00000
示例 2:
输入: 2.10000, 3
输出: 9.26100
示例 3:
输入: 2.00000, -2
输出: 0.25000
解释: 2^-2 = 1/22 = 1/4 = 0.25
说明:
-100.0 < x < 100.0
n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
 */


import com.sun.deploy.ui.AboutDialog;

/**
 * 思路：
 * 1.确定指数与零的关系，定义一个变量记录大于零还是小于零。
 * 2.计算x^(n/2),然后得到x^n
 * 3.最后加上是否倒数即可
 * <p>
 * 动态规划更快:存在问题，当n特别大时，不能创建特别大的动态规划数组，OOM
 * 循环计算得x^(n/2)即可
 */
public class Pow {
    public static void main(String[] args) {
        Pow pow = new Pow();
        double res = pow.myPow(2, Integer.MIN_VALUE);
        System.out.println(res);
    }

    public double myPow(double x, int n) {
        boolean flag = n < 0;
        long temp = (long) n;
        temp = temp > 0 ? temp : -temp;
        double res = recursion(x, temp);
        if (flag) {
            res = 1 / res;
        }

        return res;
    }

    private double recursion(double x, long n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (n == 2) {
            return x * x;
        }
        if (n % 2 == 0) {
            return recursion(x * x, n / 2);
        } else {
            return recursion(x * x, n / 2) * x;
        }
    }
}



















