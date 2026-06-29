
 class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0], p = 0;

        for (int price : prices) {
            min = Math.min(min, price);
            p = Math.max(p, price - min);
        }

        return p;
    }
}
