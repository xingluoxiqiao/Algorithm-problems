package 代码随想录.day40;

public class rob {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        //dp[i][0]表示偷当前的最大值，dp[i][1]表示不偷当前的最大值
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = 0;
        for(int i = 1; i < nums.length; i++){
            dp[i][0] = dp[i-1][1]+nums[i];
            dp[i][1] = Math.max(dp[i-1][0],dp[i-1][1]);
        }
        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,9,3,1};
        System.out.println(new rob().rob(nums));
    }


}
