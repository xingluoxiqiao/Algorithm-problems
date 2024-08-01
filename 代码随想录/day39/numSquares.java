package 代码随想录.day39;

public class numSquares {
    public int numSquares(int n) {
        int max = Integer.MAX_VALUE;
        //dp[i]表示和为n的最少平方数的数量
        int[] dp = new int[n+1];
        for(int i = 0; i <= n; i++){
            dp[i] = max;
        }
        dp[0] = 0;
        for(int i = 0; i <= 100; i++){
            for(int j = i*i; j <= n; j++){
                if(dp[j - i*i] != max){
                    dp[j] = Math.min(dp[j],dp[j-i*i]+1);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new numSquares().numSquares(12));
    }
}
