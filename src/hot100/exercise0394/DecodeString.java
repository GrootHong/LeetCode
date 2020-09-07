package hot100.exercise0394;

/*
给定一个经过编码的字符串，返回它解码后的字符串。
编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
示例 1：
输入：s = "3[a]2[bc]"
输出："aaabcbc"
示例 2：
输入：s = "3[a2[c]]"
输出："accaccacc"
示例 3：
输入：s = "2[abc]3[cd]ef"
输出："abcabccdcdcdef"
示例 4：
输入：s = "abc3[cd]xyz"
输出："abccdcdcdxyz"
 */

/**
 * 思路：
 * 1、字符串的开头只会有两种情况：要么是以数字开头，要么以字母开头
 * 2、如果以字母开头，就直接遍历到数字位置，然后将这段字母全部添加到sb中。
 * 3、如果是以数字开头，则开始循环数字次数，将方括号内部的字符串添加到sb中。
 * 4.对于方括号内部中的字符串，可以通过递归调用得到。
 */
public class DecodeString {
    String src;
    int ptr;
    public String decodeString(String s) {
        src = s;
        ptr = 0;
        return getString();
    }
    public String getString() {
        if (ptr == src.length() || src.charAt(ptr) == ']') {
            return "";
        }
        char cur = src.charAt(ptr);
        int repTime = 1;
        String ret = "";
        if (Character.isDigit(cur)) {
            repTime = getDigits();
            ++ptr;
            String str = getString();
            ++ptr;
            while (repTime-- > 0) {
                ret += str;
            }
        } else if (Character.isLetter(cur)) {
            ret = String.valueOf(src.charAt(ptr++));
        }
        return ret + getString();
    }
    public int getDigits() {
        int ret = 0;
        while (ptr < src.length() && Character.isDigit(src.charAt(ptr))) {
            ret = ret * 10 + src.charAt(ptr++) - '0';
        }
        return ret;
    }
}
