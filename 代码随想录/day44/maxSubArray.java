package 代码随想录.day44;

public class maxSubArray {
    public int maxSubArray(int[] nums) {
        //dp[i]表示以nums[i]结尾的最大连续子数组和
        int[] dp = new int[nums.length];
        int res = 0;
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,4,-1,7,8};
        System.out.println(new maxSubArray().maxSubArray(nums));
    }
}
