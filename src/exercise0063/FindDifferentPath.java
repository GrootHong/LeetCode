package exercise0063;

/*
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
问总共有多少条不同的路径？
 */


/**
 * 思路：
 * 回溯算法：走路策略，先向下，再向左。
 * 1.定义一个计数器，每成功一种，计数器加1；
 * 2.确定行和列大小，每走一步，行列都变换，用到递归
 * 3.行列都为0时，为一种路径，计数器加1，返回
 *
 * 基于上述方法花费时间太长，考虑动态规划
 */
public class FindDifferentPath {

    public static void main(String[] args) {
        FindDifferentPath f = new FindDifferentPath();
        long start = System.currentTimeMillis();
        int count = f.uniquePaths(51,9);
        long end = System.currentTimeMillis();
        System.out.println(count);
        System.out.println(end-start);
    }
    private int count = 0;
    public int uniquePaths(int m, int n) {
        if(m==0||n==0){
            return 0;
        }
        recursion(m,n);
        return count;
    }

    private void recursion(int m,int n){
        if(m==1&&n==1){
            count += 1;
            return;
        }
        //向下走
        if(m>1){
            recursion(m-1,n);
        }
        //向右走
        if(n>1){
            recursion(m,n-1);
        }
    }

}
