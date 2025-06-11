class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int sell = prices[0];
        int profit = sell - buy;

        for (int price : prices) {
            if (price < buy) {
                buy = price;
                sell = price;
            }

            if (price > sell) {
                sell = price;
            }

            if (sell - buy > profit) {
                profit = sell - buy;
            }
        }

        return profit;
    }
}