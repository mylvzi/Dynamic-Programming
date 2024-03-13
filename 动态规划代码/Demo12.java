package DP;

/**
 * 粉刷房子
 * 一个简单的多状态问题
 */
public class Demo12 {
    public int minCost(int[][] costs) {
        // 1.创建dp表
        int n = costs.length;
        int[][] dp = new int[n][3];

        // 2.初始化
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        // 3.填表
        for(int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1],dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0],dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0],dp[i - 1][1]) + costs[i][2];
        }

        // 4.返回值
        return Math.min(Math.min(dp[n - 1][0],dp[n - 1][1]),dp[n - 1][2]);
    }
}
