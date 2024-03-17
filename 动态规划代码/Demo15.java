package DP;

/**
 * 买卖股票的最佳时机III
 */
public class Demo15 {
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;

            // 创建两个dp表
            int m = 3;
            int[][] f = new int[n][m];
            int[][] g = new int[n][m];

            // 初始化
            f[0][0] = -prices[0];f[0][1] = f[0][2] = -0x3f3f3f3f;
            g[0][0] = 0;g[0][1] = g[0][2] = -0x3f3f3f3f;

            // 填表
            for(int i = 1; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    f[i][j] = Math.max(f[i - 1][j],g[i - 1][j] - prices[i]);
                    if(j - 1 >= 0) g[i][j] = Math.max(g[i - 1][j],f[i - 1][j - 1] + prices[i]);
                    else g[i][j] = g[i - 1][j];
                }
            }

            int ret = 0;
            for(int j = 0; j < m; j++) ret = Math.max(g[n - 1][j],ret);

            return ret;
        }
    }
}
