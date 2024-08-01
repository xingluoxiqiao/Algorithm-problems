package 代码随想录.day41;

public class maxProfit3 {
    //最多完成两笔交易
    public int maxProfit(int[] prices) {
        //状态：0当前第一次交易持有，1当前第一次交易未持有，2当前第二次交易持有，3当前第二次交易未持有
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];
        dp[0][2] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //之前已经买入或者今天买入
            dp[i][0] = Math.max(-prices[i], dp[i - 1][0]);
            //之前已经卖出或者今天卖出
            dp[i][1] = Math.max(dp[i - 1][1], dp[i][0] + prices[i]);
            //之前已经买入或者今天买入
            dp[i][2] = Math.max(dp[i - 1][2], dp[i][1] - prices[i]);
            //之前已经卖出或者今天卖出
            dp[i][3] = Math.max(dp[i - 1][3], dp[i][2] + prices[i]);
        }
        return dp[prices.length-1][3];
    }

    public static void main(String[] args) {
        int[] price = new int[]{3,3,5,0,0,3,1,4};
        System.out.println(new maxProfit3().maxProfit(price));
    }

    private void print(int[][] dp){
        int m = dp.length;
        int n = dp[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(dp[i][j]+"    ");
            }
            System.out.println();
        }
    }
}
