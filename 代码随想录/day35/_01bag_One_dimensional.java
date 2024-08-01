package 代码随想录.day35;

import java.util.Scanner;

public class _01bag_One_dimensional {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] cost = new int[m];
        int[] value = new int[m];
        for (int i = 0; i < m; i++) {
            cost[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            value[i] = sc.nextInt();
        }
        //dp[i]代表容量为i的背包能装的最大价值
        int[] dp = new int[n+1];
        for(int i = 0; i < m; i++){
            for(int j = n; j >= cost[i]; j--){
                dp[j] = Math.max(dp[j],dp[j-cost[i]]+value[i]);
            }
        }
        System.out.println(dp[n]);
    }
}
