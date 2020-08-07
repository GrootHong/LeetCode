package exercise0121;

/*
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
注意：你不能在买入股票前卖出股票
 */

import sun.applet.AppletResourceLoader;

/**
 * 思路：
 * 记录当前的最小值min，记录最大成交额max，
 * 对数组进行遍历，每次遍历到一个新数，就更新max和min
 * max = Math.max(max,array[i]-min);
 * min = Math.min(min,array[i]);
 */
public class BestOpportunityToSellStocks {
    public static void main(String[] args) {
        int[] array = {7,2,5,3,6,1,4};
        BestOpportunityToSellStocks b =new BestOpportunityToSellStocks();
        int profit = b.maxProfit(array);
        System.out.println(profit);
    }

    public int maxProfit(int[] prices) {
        if(prices.length<=1){
            return 0;
        }
        int min = prices[0];
        int max = 0;
        int temp;
        for(int i=1;i<prices.length;i++){
            temp = prices[i]-min;
            if(temp>max){
                max = temp;
            }
            if(prices[i]<min){
                min = prices[i];
            }
        }
        return max;
    }

}
