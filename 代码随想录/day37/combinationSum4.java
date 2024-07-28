package 代码随想录.day37;

public class combinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        //求排列先背包再物品
        for(int j = 0; j <= target; j++){
            for(int i = 0; i < nums.length; i++){
                //注意背包容量至少需大于当前物品
                if (j >= nums[i]) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        int target = 4;
        int res = new combinationSum4().combinationSum4(nums,target);
        System.out.println(res);
    }

}
