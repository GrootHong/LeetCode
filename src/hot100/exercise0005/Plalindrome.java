package hot100.exercise0005;

/*
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
 */

/**
 * 思路：使用动态规划算法
 * 1.创建一个二维nXn的boolean数组，n为字符串长度
 * 2.数组中a[i][j]表示字符串从i到j是否是回文的，
 * 3.根据2，可以初始化数组，对于i>j的部分，一定是false，对于i=j的部分，一定是true。
 * 4.对于i<j的部分，可以根据上一位置推到，a[i][j] = a[i+1][j-1]&(str[i]==str[j]),
 * 5.边界条件：n=1时，一定回文，n=2时，两个字符相等就回文，
 * 6.开始二重循环，for(i=0;i<n-1;i++){ for(j=i+1;j<n;j++){ }}
 *
 */
public class Plalindrome {

    public static void main(String[] args){
        Plalindrome p = new Plalindrome();
        String string = "aaaabaaaaa";
        System.out.println(p.longestPalindrome(string));
    }

    public String longestPalindrome(String s) {
        if(s==null||s.length()==0||s.length()==1){
            return s;
        }
        if(s.length()==2){
            if(s.charAt(0)==s.charAt(1)){
                return s;
            } else {
                return s.substring(0,1);
            }
        }
        //定义一个字符串保存最大回文
        String max = s.substring(0,1);
        //字符串长度大于2，开始使用动态规划
        //初始化数组
        boolean[][] b = new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            b[i][i] = true;
        }
        //开始循环,一列一列循环
        for(int j=1;j<s.length();j++){
            for(int i=0;i<j;i++){
                if(i+1==j&&s.charAt(i)==s.charAt(j)){
                    b[i][j] = true;
                    if(max.length()<j-i+1){
                        max = s.substring(i,j+1);
                    }
                } else if(i+1<j){
                    if(b[i+1][j-1]&&s.charAt(i)==s.charAt(j)){
                        b[i][j] = true;
                        if(max.length()<j-i+1){
                            max = s.substring(i,j+1);
                        }
                    }
                }
            }
        }
        return max;
    }
}
