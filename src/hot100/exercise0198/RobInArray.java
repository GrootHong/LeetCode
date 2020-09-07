package hot100.exercise0198;

/*
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 */

/**
 * 思路：第一反应，使用动态规划算法
 * 首先创建一个数组db，用于对于每个位置，存放的是每个位置春所能获得的最大金额，
 * 且最大金额的产生方式是：在前一个值和前第二个值加当前值结果的两个值中，取最大即为当前位置处的最大值。
 */
public class RobInArray {
    public static void main(String[] args) {
        int[] array = {2, 7, 9, 3, 1};
        RobInArray r = new RobInArray();
        int max = r.rob(array);
        System.out.println(max);
    }

    private int[] max;
    private int index = 0;

    public int rob(int[] nums) {
        if(nums==null||nums.length==0)
        {
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        max = new int[nums.length];
        max[0] = nums[0];
        max[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            max[i] = Math.max(max[i-1],max[i-2]+nums[i]);
        }
        return max[nums.length-1];
    }
}
