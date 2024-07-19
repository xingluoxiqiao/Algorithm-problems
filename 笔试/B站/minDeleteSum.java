package 笔试.B站;

import java.util.Scanner;

/**
 * 给定两个字符串 s1 和 s2（0 <= s1.length, s2.length <= 1000），
 * 返回使两个字符用相等所需删除字符的 ASCLL 值的最小和。
 *
 * s1 和 s2 由小写英文字母组成。
 *输入：
 * sea
 * eat
 *输出：
 * 231
 */

public class minDeleteSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        minDeleteSum minDeleteSum = new minDeleteSum();
        System.out.println(minDeleteSum.mindelete(a, b));
    }
    private int mindelete(String a, String b){
        // dp[i][j] 表示 以i-1为结尾的字符串word1，和以j-1位结尾的字符串word2，想要达到相等，
        // 所需要删除元素的最小ASCII 删除总和
        int[][] dp = new int[a.length()+1][b.length()+1];
        for(int i = 1; i <= a.length(); i++){
            dp[i][0] = dp[i-1][0] + a.charAt(i-1);
        }
        for(int j = 1; j <= b.length(); j++){
            dp[0][j] = dp[0][j-1] + b.charAt(j -1);
        }
        for(int i = 1; i <= a.length(); i++){
            for(int j = 1; j <= b.length(); j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i - 1][j] + a.charAt(i - 1), dp[i][j - 1] + b.charAt(j - 1));
                }
            }
        }
        return dp[a.length()][b.length()];
    }
}
