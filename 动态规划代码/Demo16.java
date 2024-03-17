package DP;

/**
 * 买卖股票（含手续费）
 */
public class Demo16 {
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;

            // 创建两个dp表
            int[] f = new int[n];// 买入状态
            int[] g = new int[n];// 卖出状态

            // 初始化
            f[0] = -prices[0];g[0] = 0;

            // 填表
            for(int i = 1; i < n; i++) {
                f[i] = Math.max(f[i - 1],g[i - 1] - prices[i]);
                g[i] = Math.max(g[i - 1],f[i - 1] + prices[i] - fee);
            }

            // 返回
            return f[n - 1] > g[n - 1] ? f[n - 1] : g[n - 1];

        }
    }
}
