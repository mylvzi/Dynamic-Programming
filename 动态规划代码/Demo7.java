package DP;

// 宝石的最高价值
// 也比较简单  普普通通的二维dp问题
public class Demo7 {
    public static int jewelleryValue(int[][] frame) {
        int m = frame.length;
        int n = frame[0].length;
        // 1.dp表
        int[][] dp = new int[m + 1][n + 1];

        // 2.初始化


        // 3.填表
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]) + frame[i - 1][j - 1];
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        int[][] frame = {{1,2,5},{3,2,1}};
        jewelleryValue(frame);
    }
}
