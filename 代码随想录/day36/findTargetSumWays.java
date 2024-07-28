package 代码随想录.day36;

public class findTargetSumWays {
    public int findTargetSumWays(int[] nums, int target) {
        //计算全加之和
        int sum  = 0;
        for(int num : nums){
            sum += num;
        }
        if(Math.abs(target) > sum) return 0;
        if((sum+target)%2 == 1) return 0;
        //计算符号为正的全部数之和(一定是int)
        int add = (sum + target)/2;
        int[] dp = new int[add+1];
        dp[0] = 1;
        for(int i = 0; i < nums.length; i++){
            for(int j = add; j >= nums[i]; j--){
                dp[j] += dp[j-nums[i]];
            }
        }
        return dp[add];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1};
        int res = new findTargetSumWays().findTargetSumWays(nums,3);
        System.out.println(res);
    }
}
