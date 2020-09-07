package hot100.exercise0079;

/*
给定一个二维网格和一个单词，找出该单词是否存在于网格中。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
示例:
board =
{
  {'A','B','C','E'},
  {'S','F','C','S'},
  {'A','D','E','E'}
}

{{'C','A','A'},{'A','A','A'},{'B','C','D'}}

{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}}
"ABCEFSADEESE"

{{'b','a','a','b','a','b'},{'a','b','a','a','a','a'},{'a','b','a','a','a','b'},{'a','b','a','b','b','a'},{'a','a','b','b','a','b'},{'a','a','b','b','b','a'},{'a','a','b','a','a','b'}}
"aabbbbabbaababaaaabababbaaba"
给定 word = 'ABCCED', 返回 true
给定 word = 'SEE', 返回 true
给定 word = 'ABCB', 返回 false
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

    public static void main(String[] args) {
        WordSearch w = new WordSearch();
        char[][] board = {{'b','a','a','b','a','b'},{'a','b','a','a','a','a'},{'a','b','a','a','a','b'},{'a','b','a','b','b','a'},{'a','a','b','b','a','b'},{'a','a','b','b','b','a'},{'a','a','b','a','a','b'}};
        boolean flag = w.exist(board,"aabbbbabbaababaaaabababbaaba");
        System.out.println(flag);
    }
    private int[][] status;
    public boolean exist(char[][] board, String word) {
        if(board==null||board.length==0||board[0].length==0||word==null||word.length()==0){
            return false;
        }
        //初始化状态数组
        status = new int[board.length][board[0].length];
        //都不为空。开始遍历数组，找到首字母位置
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    //开始递归
                    init();
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
        if(index==word.length()-1){
            return true;
        }
        status[row][col] = 1;
        //向上走
        if(row>0&&status[row-1][col]==0){
            if(board[row-1][col]==word.charAt(index+1)){
                boolean flag = recursion(board,word,row-1,col,index+1);
                if(flag){
                    return flag;
                }
            }
        }
        //向右走
        if(col<board[0].length-1&&status[row][col+1]==0){
            if(board[row][col+1]==word.charAt(index+1)){
                boolean flag =  recursion(board,word,row,col+1,index+1);
                if(flag){
                    return flag;
                }
            }
        }
        //向下走
        if(row<board.length-1&&status[row+1][col]==0){
            if(board[row+1][col]==word.charAt(index+1)){
                boolean flag =  recursion(board,word,row+1,col,index+1);
                if(flag){
                    return flag;
                }
            }
        }
        //向左走
        if(col>0&&status[row][col-1]==0){
            if(board[row][col-1]==word.charAt(index+1)){
                return recursion(board,word,row,col-1,index+1);
            }
        }
        status[row][col] = 0;
        return false;
    }

    private void init(){
        for(int i=0;i<status.length;i++){
            for(int j=0;j<status[0].length;j++){
                status[i][j] = 0;
            }
        }
    }

}






