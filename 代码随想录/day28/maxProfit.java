package 代码随想录.day28;

public class maxProfit {
    public int maxProfit(int[] prices) {
        int res = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i-1]){
                res += prices[i] - prices[i-1];
            }
        }
        return res;
    }
}
