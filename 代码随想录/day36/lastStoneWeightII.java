package 代码随想录.day36;

public class lastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int num : stones){
            sum += num;
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
        int[] stones = new int[]{31,26,33,21,40};
        System.out.println(new lastStoneWeightII().lastStoneWeightII(stones));
    }
}
