package exercise44;

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
 * 思路：
 * 1.判断字符串或正则是否为null，是则返回false
 * 2.判断字符串和正则是否长度同时为0，是则true
 */
public class MatchString {

    public static void main(String[] args) {
        String s = "bbbababbbbabbbbababbaaabbaababbbaabbbaaaabbbaaaabb";
        String regex =  "*b********bb*b*bbbbb*ba";
        long start = System.currentTimeMillis();
        boolean flag = isMatch(s, regex);
        long end = System.currentTimeMillis();
        System.out.println(flag);
        System.out.println(end-start);
    }

    /**
     * 对传入的字符串和正则进行匹配
     *
     * @param s 传入的字符串
     * @param p 传入的正则
     * @return 返回是否匹配
     */
    public static boolean isMatch(String s, String p) {
        //如果传入的字符串或者正则为空，则返回false，
        if (s == null || p == null) {
            return false;
        }
        //如果两者同时长度为0，或者p的后面所以字符是*，则返回true
        if (s.length() == 0 && (p.length() == 0 || (p.length() != 0 && p.replace("*","").length()==0))) {
            return true;
        }
        //如果s长度为0；但是p的长度不为0，或者为1，但最后一个字符不是*，则返回false
        else if (s.length() == 0 && ((p.length() == 1 && p.charAt(0) != '*') || p.length() > 1)) {
            return false;
        }
        //如果两者长度都不为0，则递归比较两者的第一个字符
        else if (s.length() != 0 && p.length() != 0) {
            //如果p的第一个字符是？，则直接比较两者下一个字符
            if (p.charAt(0) == '?') {
                return isMatch(s.substring(1), p.substring(1));
            }
/*------------------------------------------------------------------------------------------------------*/
/*-------------------------------递归太多次，花费时间太长，85s--------------------------------------------*/
/*------------------------------------------------------------------------------------------------------*/
            //如果p的第一个字符是*
            else if (p.charAt(0) == '*') {
                if (p.length() > 1) {
                    //暂存p后的第一个字符
                    char ch = p.charAt(1);
                    int index = 0;
                    for(int i=0;i<p.length();i++){
                        if(p.charAt(i)!='*'){
                            ch = p.charAt(i);
                            break;
                        }
                        index = i;
                    }
                    //如果后面全是*，直接返回true；
                    if(index==p.length()-1){
                        return true;
                    }
                    //开始遍历s字符串，遍历到字符ch就进行递归
                    boolean flag = false;
                    for (int i = 0; i < s.length(); i++) {
                        if (s.charAt(i) == ch||ch =='?') {
                            flag = isMatch(s.substring(i), p.substring(1));
                            if (flag) {
                                return true;
                            }
                        }
                    }
                } else {
                    //正则只有一个*，直接返回true；
                    return true;
                }
            }
/*------------------------------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------------------------------*/
            //如果p的第一个字符就是普通字符
            else {
                if (s.charAt(0) == p.charAt(0)) {
                    return isMatch(s.substring(1), p.substring(1));
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}






