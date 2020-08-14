package exercise0200;

/*
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
此外，你可以假设该网格的四条边均被水包围。
示例 2:
输入:
{
{'1','1','0','0','0'},
{'1','1','0','0','0'},
{'0','0','1','0','0'},
{'0','0','0','1','1'}
}
输出: 3

{
{'1','1','1','1','0'},
{'1','1','0','1','0'},
{'1','1','0','0','0'},
{'0','0','0','0','0'}
}
 */

/**
 * 思路：
 * 对字符数组进行遍历。找到一个1后，就递归回溯，找到所有的相邻的1，并将其改为2，回溯结束说明找到一块岛屿，
 * 计数器加1，然后继续遍历下一个1，一直遍历到整个二维数组中不再含有1为止
 */
public class IslandNumber {

    public static void main(String[] args) {
        char[][] chars = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        IslandNumber i = new IslandNumber();
        int count = i.numIslands(chars);
        System.out.println(count);
    }
    
    public int numIslands(char[][] grid) {
        int count = 0;
        if(grid==null||grid.length==0||grid[0].length==0){
            return count;
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    recursion(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private void recursion(char[][] grid,int i,int j){
        //首先将当前位置设置为2
        grid[i][j]='2';
        //然后按照上右下左的顺序递归回溯，找到所有相邻的1
        //向上
        if(i>0&&grid[i-1][j]=='1'){
            recursion(grid,i-1,j);
        }
        //向右
        if(j<grid[0].length-1&&grid[i][j+1]=='1'){
            recursion(grid,i,j+1);
        }
        //向左
        if(j>0&&grid[i][j-1]=='1'){
            recursion(grid,i,j-1);
        }
        //向下
        if(i<grid.length-1&&grid[i+1][j]=='1'){
            recursion(grid,i+1,j);
        }
    }
}
