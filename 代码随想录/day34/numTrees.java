package 代码随想录.day34;

public class numTrees {
    public int numTrees(int n) {
        //dp[n]表示节点数为n时能构建的二叉搜索树的数量
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <=n; i++){
            //j用于遍历左子树节点个数
            for(int j = 0; j < i; j++){
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new numTrees().numTrees(3));
    }

}
