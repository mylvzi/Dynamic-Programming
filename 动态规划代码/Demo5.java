package DP;

public class Demo5 {
    // 本题是一个经典的二维的dp问题
    // 掌握思路之后就比较简单
    // 需要注意的点:
    // 1.初始化时尽量使用"辅助节点"的方式  对于二维的dp问题来说,就是扩增一行一列
    // 2.要画图分析每一步是怎么来的  通过画图才能很好的找到状态表示和状态转移方程
    public int uniquePaths(int m, int n) {
        // 1.准备dp表
        int[][] dp = new int[m + 1][n + 1];

        // 2.初始化
        dp[0][1] = 1;

        // 3.填表
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m][n];
    }
}
