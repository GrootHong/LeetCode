package hot100.exercise0070;

/*
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
注意：给定 n 是一个正整数。
 */

/**
 * 思路：
 * 类似斐波那契数列，
 * f(n)=f(n-1)+f(n-2);
 * 如果用递归，会有很多不必要的重复计算。因此可以采用循环实现，
 * 定义一个长度为n的数组，将f(n)设置在索引为n的位置，然后后面的每一个数都是前两个数相加
 * 最后返回数组中索引为n的值就可。
 *
 * 可能会超出int界限，使用大数？
 */
public class Upstairs {

    public static void main(String[] args) {
        Upstairs u= new Upstairs();
        int n = 10;
        int kinds = u.climbStairs(n);
        System.out.println(kinds);
    }

    public int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int[] array = new int[n+1];
        array[0] = 1;
        array[1] = 1;
        array[2] = 2;
        for(int i=3;i<n+1;i++){
            array[i] = array[i-1]+array[i-2];
        }
        return array[n];
    }
}
