package 代码随想录.day43;

public class findLength {
    public int findLength(int[] nums1, int[] nums2) {
        //这里有优化思路，可以扩大dp数组dp[nums1+1][nums2+1]，这样就不用初始化第一列
        //并且由于每一行都可以由上一行推出，可以简化为一维数组，但注意倒序遍历
        //dp[i][j]表示以nums1[i],nums2[j]结尾的最大相同子数组的长度
        int res = 0;
        int[][] dp = new int[nums1.length][nums2.length];
        for(int i = 0; i < nums1.length; i++){
            if(nums1[i] == nums2[0]){
                dp[i][0] = 1;
                res = 1;
            }
        }
        for(int j = 0; j < nums2.length; j++){
            if(nums1[0] == nums2[j]){
                dp[0][j] = 1;
                res = 1;
            }
        }
        for(int i = 1; i < nums1.length; i++){
            for(int j = 1; j < nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    dp[i][j] = dp[i-1][j-1]+1;
                    res = Math.max(res,dp[i][j]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,2,1};
        int[] nums2 = new int[]{3,2,1,4,7};
        System.out.println(new findLength().findLength(nums1,nums2));
    }
}
