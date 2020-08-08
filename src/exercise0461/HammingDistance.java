package exercise0461;

/*
两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
给出两个整数 x 和 y，计算它们之间的汉明距离。
 */

import java.util.Hashtable;

/**
 * 思路：
 * 两个数异或之后，不相同的位置为1，相同的位置为0，
 * 所以将两个数异或之后得到的结果，得到这个结果中1的个数即可
 * 若个得到一个数中1的个数，可以使用1向左移位与得到。但是需要比较32次。
 */
public class HammingDistance {
    public static void main(String[] args) {
        HammingDistance h = new HammingDistance();
        System.out.println(h.hammingDistance(1,4));
    }
    public int hammingDistance(int x, int y) {
        int count = 0;
        int result = x^y;
        int index = 1;
        for(int i=0;i<32;i++){
            if((index&result)==index){
                count++;
            }
            index = index<<1;
        }
        return count;
    }
}
