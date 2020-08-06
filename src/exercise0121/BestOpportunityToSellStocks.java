package exercise0121;

/*
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
注意：你不能在买入股票前卖出股票
 */
public class BestOpportunityToSellStocks {
    public static void main(String[] args) {
        int[] array = {7,1,5,3,6,4};
        BestOpportunityToSellStocks b =new BestOpportunityToSellStocks();
        int profit = b.maxProfit(array);
        System.out.println(profit);
    }

    public int maxProfit(int[] prices) {

    }

}
