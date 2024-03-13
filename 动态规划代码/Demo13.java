package DP;

/**
 * 买卖股票的最佳时机
 * 此题也是一个多状态问题
 * 把三个状态都画出来  去分析状态转移方程
 */
public class Demo13 {
    public int maxProfit(int[] prices) {
        // 1.创建dp表
        int n = prices.length;
        if(n == 1) return 0;
        int[][] dp = new int[n][3];

        // 2.初始化
        dp[0][0] = -prices[0];

        // 3.赋值
        for(int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][2]);
            dp[i][2] = dp[i - 1][0] + prices[i];
        }

        // 4.返回结果
        return Math.max(Math.max(dp[n - 1][0],dp[n - 1][1]),dp[n - 1][2]);
    }
}
