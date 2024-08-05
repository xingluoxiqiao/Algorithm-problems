package 代码随想录.day44;

public class longestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int res = 0;
        //dp[i][j]表示以text1[i-1],text2[j-1]结尾的最大公共子序列长度
        //扩大dp数组避免初始化
        int[][] dp = new int[len1+1][len2+1];
        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                char c1 = text1.charAt(i-1);
                char c2 = text2.charAt(j-1);
                if(c1 == c2){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        System.out.println(new longestCommonSubsequence().longestCommonSubsequence("abc","abc"));
    }
}
