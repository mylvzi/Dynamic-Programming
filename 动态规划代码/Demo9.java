package DP;

/**
 * 地下城勇士
 * 此题比较特殊
 * 状态表示:是"以i位置为起点巴拉巴拉",和之前的正好反过来
 * 原因在于使用"以i位置为结尾这样的操作"需要考虑的结果太多
 * 当前位置的状态不仅受到之前状态的影响,还收到下一位置状态的影响
 * 转变思路:改为以i位置为结尾
 *
 * 还需要注意的是此时初始化,填表顺序,返回值都有所不同
 * 初始化是右下方初始化,填表顺序是从最后一个位置开始,返回值是返回dp[0][0]
 */
public class Demo9 {
    public int calculateMinimumHP(int[][] dungeon) {

        int m = dungeon.length;
        int n = dungeon[0].length;

        // 1.创建dp表
        int[][] dp = new int[m + 1][n + 1];

        // 2.初始化
        for(int j = 0; j < n - 1; j++) dp[m][j] = Integer.MAX_VALUE;
        for(int i = 0; i < m - 1; i++) dp[i][n] = Integer.MAX_VALUE;

        dp[m - 1][n] = dp[m][n - 1] = 1;

        // 3.填表
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int tmp = Math.min(dp[i][j + 1],dp[i+1][j]) - dungeon[i][j];

                // 处理dungeon[i][j]过大的情况
                // 发现此处如果使用三目运算符会更快一些
                dp[i][j] = tmp <= 0 ? 1 : tmp;
            }
        }

        // 使用dp表  此时应该返回的是dp[0][0]
        // 从起点走到终点所需要的最小点数
        return dp[0][0];
    }
}
