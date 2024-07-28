package 代码随想录.day37;

public class change {
    public int change(int amount, int[] coins) {
        //dp[i]表示金额为i时的最大方案数
        int[] dp = new int[amount+1];
        dp[0] = 1;
        //求组合先物品再背包
        for(int i = 0; i < coins.length; i++){
            for(int j = coins[i]; j <= amount; j++){
                dp[j] += dp[j-coins[i]];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        int amount = 5;
        int res = new change().change(amount,coins);
        System.out.println(res);
    }
}
