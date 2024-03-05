package DP;

/**
 * Created with IntelliJ IDEA.
 * Description:动态规划第三题
 * User: 绿字
 * Date: 2024-01-19
 * Time: 21:40
 */
public class Demo3 {
    public int minCostClimbingStairs(int[] cost) {
        // 1.创建dp表
        // 2.初始化
        // 3.填表
        // 4.返回值

        // 处理细节问题
        int n = cost.length;
        if(n == 2) {
            return Math.min(cost[0],cost[1]);
        }
        int[] dp = new int[n + 1];// 创建dp表

        dp[0] = dp[1] = 0;// 初始化

        for(int i = 2; i <= n; i++) {// 填表
            dp[i] = Math.min(dp[i - 1] + cost[i - 1] , dp[i - 2] + cost[i - 2]);
        }

        return dp[n];
    }
    public static void main(String[] args) {

    }
}
