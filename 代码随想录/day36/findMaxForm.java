package 代码随想录.day36;

public class findMaxForm {
    public int findMaxForm(String[] strs, int m, int n) {
        //dp[i][j]是含i个0，j个1的最大字符串数量
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i < strs.length; i++){
            int zeroNum = getZero(strs[i])[0];
            int ontNum = getZero(strs[i])[1];
            for(int k = m; k >= zeroNum; k--){
                for(int l = n; l >= ontNum; l--){
                    dp[k][l] = Math.max(dp[k][l],dp[k-zeroNum][l-ontNum]+1);
                }
            }
        }
        return dp[m][n];
    }
    private int[] getZero(String s){
        int zero = 0, one = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                zero++;
            }else one++;
        }
        return new int[]{zero,one};
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"10", "0", "1"};
        int res = new findMaxForm().findMaxForm(strings,1,1);
        System.out.println(res);
    }

}
