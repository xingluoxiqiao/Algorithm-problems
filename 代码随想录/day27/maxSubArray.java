package 代码随想录.day27;

public class maxSubArray {
    public int maxSubArray(int[] nums) {
        //dp[i] 表示以nums[i]结尾的子数组中的最大和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for(int i = 1; i< nums.length; i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            res = Math.max(dp[i],res);
        }
        return res;
    }
}
