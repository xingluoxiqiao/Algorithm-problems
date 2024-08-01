package 代码随想录.day39;

public class coinChange {
    public int coinChange(int[] coins, int amount) {
        int max = Integer.MAX_VALUE;
        //dp[i]表示金额为i时所需的最小硬币数
        int[] dp = new int[amount+1];
        for(int i = 0; i <= amount; i++){
            dp[i] = max;
        }
        dp[0] = 0;
        for(int i = 0; i < coins.length; i++){
            for(int j = coins[i]; j <= amount; j++){
                //只有dp[j-coins[i]]不是初始最大值时，该位才有选择的必要
                if (dp[j - coins[i]] != max) {
                    //选择硬币数目最小的情况
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }

    public static void main(String[] args) {
        int[] coins = new int[]{2};
        System.out.println(new coinChange().coinChange(coins,3));
    }
}
