package 代码随想录.day43;

import java.util.Arrays;

public class lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int res = 1;
        // dp[i]是以nums[i]结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        for(int i = 0; i < nums.length; i++){
            System.out.print(dp[i]+" ");
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(new lengthOfLIS().lengthOfLIS(nums));
    }
}
