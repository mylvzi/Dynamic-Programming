package DP;

/**
 * 最小的下降路径和
 * 比较简单  自己分析一下即可
 * 这里的扩容稍微有点不同  行增加一行  列增加两列
 *
 * 注意:尽量减少使用三目运算符  可读性太差
 * 求最小值还是推荐使用自带的函数
 * 简单易懂
 */
public class Demo8 {
    public int minFallingPathSum(int[][] matrix) {
        // 1.创建dp表
        int n = matrix.length;
        int[][] dp = new int[n + 1][n + 2];

        // 2.初始化
        // 第0列
        for(int i = 1; i <= n; i++) {
            dp[i][0] = dp[i][n + 1] = Integer.MAX_VALUE;
        }

        // 3.填表
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                int n1 = dp[i - 1][j - 1],n2 = dp[i - 1][j],n3 = dp[i - 1][j + 1];
                dp[i][j] = Math.min(n1,Math.min(n2,n3)) + matrix[i - 1][j - 1];
            }
        }

        // 找最后一行的最小值
        int min = dp[n][1];
        for(int j = 1; j < n + 1; j++) {
            min = Math.min(min,dp[n][j]);
        }

        return min;
    }
}
