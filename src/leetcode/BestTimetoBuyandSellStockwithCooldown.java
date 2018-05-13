package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : BestTimetoBuyandSellStockwithCooldown
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 309. Best Time to Buy and Sell Stock with Cooldown
 */
public class BestTimetoBuyandSellStockwithCooldown {
    /**
     * buy[i]表示在第i天之前最后一个操作是买，此时的最大收益。

     sell[i]表示在第i天之前最后一个操作是卖，此时的最大收益。

     rest[i]表示在第i天之前最后一个操作是冷冻期，此时的最大收益。

     我们写出递推式为：

     buy[i]  = max(rest[i-1] - price, buy[i-1])
     sell[i] = max(buy[i-1] + price, sell[i-1])
     rest[i] = max(sell[i-1], buy[i-1], rest[i-1])

     上述递推式很好的表示了在买之前有冷冻期，买之前要卖掉之前的股票。一个小技巧是如何保证[buy, rest, buy]的情况不会出现，
     这是由于buy[i] <= rest[i]， 即rest[i] = max(sell[i-1], rest[i-1])，这保证了[buy, rest, buy]不会出现。

     另外，由于冷冻期的存在，我们可以得出rest[i] = sell[i-1]，这样，我们可以将上面三个递推式精简到两个：

     buy[i]  = max(sell[i-2] - price, buy[i-1])
     sell[i] = max(buy[i-1] + price, sell[i-1])

     time : O(n)
     space : O(1)

     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int sell = 0, prevSell = 0;
        int buy = Integer.MIN_VALUE, prevBuy = 0;
        for (int price : prices) {
            prevBuy = buy;
            buy = Math.max(prevSell - price, prevBuy);
            prevSell = sell;
            sell = Math.max(prevBuy + price, prevSell);
        }
        return sell;
    }
}
