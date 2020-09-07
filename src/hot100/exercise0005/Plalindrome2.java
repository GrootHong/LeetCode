package hot100.exercise0005;

/*
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
 */

/**
 * 思路：使用中心扩展法
 * 1.判空，
 * 2.当字符串不为空时，定义两个个指针从头指向字符串
 * 3.如果指针左边与指针相等，则同时分别向左向右移动，找到最大相同位置
 * 4.如果指针右边与指针相等，也同时分别向左向右移动，找到最大相同位置
 * 5.固定中间不动，比较左右是否相等，相等同时向左右移动，找到最大相同位置
 * 6.最终将所有遍历情况下的最大相同返回就是最长回文
 */
public class Plalindrome2 {

    public static void main(String[] args) {
        String s = "aabcdbaa";
        Plalindrome2 p = new Plalindrome2();
        System.out.println(p.longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }
        String max = s.substring(0, 1);
        //字符串长度大于1；开始遍历
        for (int i = 0; i < s.length(); i++) {
            //向左找最长
            int left = i;
            int right = i;
            while (left - 1 >= 0 && right < s.length()) {
                if (s.charAt(left - 1) == s.charAt(right)) {
                    left--;
                    right++;
                } else {
                    break;
                }
            }

            if (right - left + 1 > max.length()) {
                max = s.substring(left, right+1);
            }
            //向右找最长
            while (left >= 0 && right + 1 < s.length()) {
                if(s.charAt(left)==s.charAt(right+1)){
                    left--;
                    right++;
                } else {
                    break;
                }
            }

            if (right - left + 1 > max.length()) {
                max = s.substring(left, right+1);
            }
            //向两边找最长
            while(left-1>=0&&right+1<s.length()){
                if(s.charAt(left-1)==s.charAt(right+1)){
                    left--;
                    right++;
                } else {
                    break;
                }
            }

            if (right - left + 1 > max.length()) {
                max = s.substring(left, right+1);
            }
        }
        return max;
    }
}
