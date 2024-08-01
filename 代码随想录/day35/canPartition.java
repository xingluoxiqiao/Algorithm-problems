package 代码随想录.day35;

public class canPartition {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum%2 != 0) return false;

        //相当于01背包是否能填满
        //原数组是物品的cost和value，dp[target] == target时，数组装满
        int[] dp = new int[sum/2+1];
        for(int i = 0; i < nums.length; i++){
            for(int k = sum/2; k >= nums[i]; k--){
                dp[k]  = Math.max(dp[k],dp[k-nums[i]]+nums[i]);
            }
        }
        return dp[sum/2] == sum/2;
    }


    //回溯法
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum%2 != 0) return false;
        return back(nums,0,sum/2,0);

    }
    private boolean back(int[] nums,int start,int sum,int curSum){
        if(sum == curSum){
            return true;
        }
        for(int i = start; i < nums.length; i++){
            if(back(nums,i+1,sum,curSum+nums[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,6,12,5};
        System.out.println(new canPartition().canPartition2(nums));
    }

}
