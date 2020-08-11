package exercise0079;

/*
给定一个二维网格和一个单词，找出该单词是否存在于网格中。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
示例:
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false
 */

/**
 * 思路：
 * 定义一个字符数组大小相同的数组，并定义三种状态，0，未走过，1，走过能走通，2走过不能走通
 * 1.首先遍历整个字符数组，找到word的第一个字母。并将当前位置设为1，
 * 2.然后在找到的位置开始按照上右下左的顺序查看下一位是否满足，满足就进入下一位，开始递归，
 * 3.不满足就将当前位设置位2，继续遍历首字母的下一位置。
 * 4.当遍历完所有位置都没有找到，返回false。
 * 5.当递归找到合适路径，就返回true。
 */
public class WordSearch {
    private int[][] status;
    public boolean exist(char[][] board, String word) {
        if(board==null||board.length==0||board[0].length==0||word==null||word.length()==0){
            return false;
        }
        //都不为空。开始遍历数组，找到首字母位置
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    //开始递归
                    boolean flag =  recursion(board,word,i,j,0);
                    if(flag){
                        return true;
                    }
                }
            }
        }
        //整个遍历完都没有找到目标首字母
        return false;
    }

    private boolean recursion(char[][] board,String word,int row,int col,int index){
        if(index==word.length()){
            return true;
        }
        status[row][col] = 1;
        if(row>0&&status[row-1][col]==0){
            if(board[row-1][col]==word.charAt(index+1)){
                status[row-1][col] = 1;
                return recursion(board,word,row-1,col,index+1);
            } else {
                status[row-1][col] = 2;
            }
        } else if(col<board[0].length-1&&status[row][col+1]==0){
            if(board[row][col+1]==word.charAt(index+1)){
                status[row][col] = 1;
                return recursion(board,word,row,col+1,index+1);
            } else {
                status[row][col+1] = 2;
            }
        } else if(row<board.length-1&&status[row+1][col]==0){
            if(board[row+1][col]==word.charAt(index+1)){
                status[row+1][col] = 1;
                return recursion(board,word,row+1,col,index+1);
            } else {
                status[row+1][col] = 2;
            }
        } else if(col>0&&status[row][col-1]==0){
            if(board[row][col-1]==word.charAt(index+1)){
                status[row][col-1] = 1;
                return recursion(board,word,row,col-1,index+1);
            } else {
                status[row][col-1] = 2;

            }
        } else {
            return false;
        }
    }

}






