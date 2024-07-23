package 代码随想录.day34;

public class integerBreak {
    public int integerBreak(int n) {
        //dp[i]表示i拆分能获得的最大乘积
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i/2; j++){
                //有两种方式拆分i，拆成i-j和j ，以及将i-j再次拆分
                int max =Math.max(j*(i-j),j*dp[i-j]);
                dp[i] = Math.max(dp[i],max);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new integerBreak().integerBreak(10));
    }
}
