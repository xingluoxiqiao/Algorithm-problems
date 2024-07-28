package 代码随想录.day36;

import java.util.Arrays;

public class lastStoneWeightII {
    //不能用贪心算法，优先处理大的不一定是最优解
    //尽可能均分为两部分，01背包
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int stone : stones){
            sum += stone;
        }
        int[] dp = new int[sum/2+1];
        for(int i = 0; i < stones.length; i++){
            for(int j = sum/2; j >= stones[i]; j--){
                    dp[j] = Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        return sum - 2*dp[sum/2];
    }

    public static void main(String[] args) {
        int[] stones = new int[]{2,7,4,1,8,1};
        int res = new lastStoneWeightII().lastStoneWeightII(stones);
        System.out.println(res);
    }
}
