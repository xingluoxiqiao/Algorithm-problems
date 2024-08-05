package 代码随想录.day42;

public class maxProfit4 {
    public int maxProfit(int k, int[] prices) {
        // 天数；交易次数；是否持有股票
        // 后面要用到前一次交易，但第一次交易不好初始化，干脆直接定义为k+1，空出一个
        int[][][] dp = new int[prices.length][k+1][2];
        //初始化所有的交易次数是为确保 最后结果是最多 k 次买卖的最大利润
        for (int i = 0; i <= k; i++) {
            dp[0][i][1] = -prices[0];
        }
        for(int i = 1; i < prices.length; i++){
            for(int j = 1; j <= k; j++){
                //买入+卖出算是一次交易，这里固定买入作为一次交易，卖出不算是一次交易
                //所以这里是dp[i-1][j][1]+prices[i]
                dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i]);
                //当前持有股票，前一天就持有，或今天买了
                dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i]);
            }
        }
        return dp[prices.length-1][k][0];
    }

    public static void main(String[] args) {
        int[] price = new int[]{3,2,6,5,0,3};
        System.out.println(new maxProfit4().maxProfit(2,price));
    }
}
