package leecode;

public class Algorithms_121 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 动态规划 ---  股票，买卖最优解
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {

		if (prices.length < 2) {
			return 0;
		}
		int profit = 0;
		int minPrice = 0;
		for (int i = 0; i < prices.length; i++) {
			if (i == 0) {
				profit = 0;
				minPrice = prices[i];
			}
			profit = Math.max(profit, prices[i] - minPrice);
			minPrice = Math.min(minPrice, prices[i]);
		}
		return profit;
	}
}
