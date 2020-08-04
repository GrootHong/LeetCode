package exercise0044;

/*
题目44：通配符匹配
给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
'?' 可以匹配任何单个字符。
'*' 可以匹配任意字符串（包括空字符串）。
两个字符串完全匹配才算匹配成功。

说明:
s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 */

/**
 * 思路：使用动态规划算法思路
 * 1.创建一个二维boolean数组，存放每个位置是否匹配的信息，arr = boolean[s.length()+1][p.length()+1];
 * 2.初始化二维数组，对于arr[0][j],第一行，只有当p中的所有字符都是*才为true，否则为false
 *   对于arr[i][0],第一列，不论s中为什么值都是false；
 * 3.开始比较arr[i][j]，
 *  3.1如果arr[i-1][j-1]==true&&(s[i]==p[j]||p[j]=='?'){arr[i][j]=true},再比较arr[i+1][j+1].
 *  3.2如果p[j]='*'&&(arr[i-1][j]==true||arr[i][j-1]==true){arr[i][j]=true},
 */
public class MatchString2 {
    public static void main(String[] args) {
        String s = "bbbababbbbabbbbababbaaabbaababbbaabbbaaaabbbaaaabb";
        String regex =  "*b*bb*b*bbbbb*ba";
        long start = System.currentTimeMillis();
        boolean flag = isMatch(s, regex);
        long end = System.currentTimeMillis();
        System.out.println(flag);
        System.out.println(end-start);
    }

    public static boolean isMatch(String s, String p) {
        boolean[][] arr = new boolean[s.length()+1][p.length()+1];
        arr[0][0] = true;
        for(int j=1;j<p.length()+1;j++){
            if(p.charAt(j-1)=='*'){
                arr[0][j] = arr[0][j-1];
            }
        }
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < p.length() + 1; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    arr[i][j] = arr[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    arr[i][j] = arr[i][j - 1] || arr[i - 1][j];
                }
            }
        }
        return arr[s.length()][p.length()];

    }
}
