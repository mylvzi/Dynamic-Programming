package DP;

// 不同路径II(直接复制I的代码+一个条件判断即可)
public class Demo6 {
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            // 1.准备dp表
            int[][] dp = new int[m + 1][n + 1];

            // 2.初始化
            dp[0][1] = 1;

            // 3.填表
            for(int i = 1; i <= m; i++) {
                for(int j = 1; j <= n; j++) {
                    if(obstacleGrid[i - 1][j - 1] != 1) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }else {
                        dp[i][j] = 0;
                    }

                }
            }

            return dp[m][n];
        }
    }
}
