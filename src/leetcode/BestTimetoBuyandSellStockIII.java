package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : BestTimetoBuyandSellStockIII
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 123. Best Time to Buy and Sell Stock III
 */
public class BestTimetoBuyandSellStockIII {

    /**
     * time : O(n)
     * space : O(1)
     * @param prices
     * @return
     */

    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        int sell1 = 0, sell2 = 0;
        for (int price : prices) {
            sell2 = Math.max(sell2, buy2 + price);
            buy2 = Math.max(buy2, sell1 - price);
            sell1 = Math.max(sell1, buy1 + price);
            buy1 = Math.max(buy1, -price);
        }
        return sell2;
    }
}
