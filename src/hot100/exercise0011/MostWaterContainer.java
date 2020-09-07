package hot100.exercise0011;

/*
给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
说明：你不能倾斜容器，且 n 的值至少为 2。
 */

/**
 * 思路：
 * 定义两个指针，一个指向数组的头，一个指向数组的尾。
 * 计算出两者之间的容量，并保存
 * 将值较小的那个指针向前移动一位，继续比较，
 * 最后到两个指针会合时，结束遍历，返回保存的最大值。
 */
public class MostWaterContainer {

    public static void main(String[] args) {
        int[] a = {2,3,4,5,18,17,6};
        MostWaterContainer m = new MostWaterContainer();
        System.out.println(m.maxArea(a));
    }

    public int maxArea(int[] height) {
        if(height==null||height.length<2){
            return 0;
        }
        if(height.length==2){
            return Math.min(height[0],height[1]);
        }
        int max = 0;
        int start = 0;
        int end = height.length-1;
        while (start!=end){
            int temp = Math.min(height[start],height[end])*(end-start);
            if(max<temp){
                max = temp;
            }
            if(height[start]<=height[end]){
                start++;
            } else {
                end--;
            }
        }
        return  max;
    }
}
