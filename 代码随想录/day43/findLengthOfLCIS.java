package 代码随想录.day43;

public class findLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for(int i = 1; i < nums.length; i++){
            dp[i] = nums[i] > nums[i-1]? dp[i-1]+1 : 1;
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,4,7};
        System.out.println(new findLengthOfLCIS().findLengthOfLCIS(nums));
    }
}
