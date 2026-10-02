class Solution {
    public int maxProfit(int[] prices) {
        int buyDay = 0;
        int sellDay = 0;
        int maxP = 0;

        while (sellDay < prices.length) {
            if(prices[buyDay] < prices[sellDay]) {
                int profit = prices[sellDay] - prices[buyDay];

                maxP = Math.max(maxP, profit);
            } else {
                buyDay = sellDay;
            }
            sellDay++;
        }
        return maxP;
        
    }
}
