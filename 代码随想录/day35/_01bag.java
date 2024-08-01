package 代码随想录.day35;

import java.util.Scanner;

public class _01bag {
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
        //dp[i][j]是容量为i的背包在下标为[0-j]的物体中选择时能装的最大价值
        int[][] dp = new int[n + 1][m];
        for (int i = cost[0]; i <= n; i++) {
            dp[i][0] = value[0];
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < m; j++) {
                if (i < cost[j]) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - cost[j]][j-1] + value[j]);
                }
            }
        }
        System.out.println(dp[n][m - 1]);
    }
}
