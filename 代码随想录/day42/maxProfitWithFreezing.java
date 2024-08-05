package 代码随想录.day42;

public class maxProfitWithFreezing {
    public int maxProfit(int[] prices) {
        //0未持有股票处于冷冻期，持有股票处于冷冻期不可能
        //1未持有股票不处于冷冻期，2持有股票不处于冷冻期
        int[][] dp = new int[prices.length][3];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = -prices[0];
        for(int i = 1; i < prices.length; i++){
            //昨天卖出
            dp[i][0] = Math.max(dp[i-1][1]+prices[i-1],dp[i-1][2]+prices[i-1]);
            //昨天未持有股票，是冷冻期或不是冷冻期 或今天卖的
            dp[i][1] = Math.max(dp[i-1][0],dp[i-1][1]);
            //昨天本来就持有或今天买的
            dp[i][2] = Math.max(dp[i-1][2],Math.max(dp[i-1][0]-prices[i],dp[i-1][1]-prices[i]));
        }
        return Math.max(dp[prices.length-1][0],dp[prices.length-1][1]);
    }

    public static void main(String[] args) {
        int[] price = new int[]{1,2,3,0,2};
        System.out.println(new maxProfitWithFreezing().maxProfit(price));
    }
}
