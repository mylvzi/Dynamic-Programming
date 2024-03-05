package DP;

/**
 * Created with IntelliJ IDEA.
 * Description:爬楼梯问题(easy)
 * User: 绿字
 * Date: 2024-01-18
 * Time: 21:38
 */
public class Demo2 {
    public int waysToStep(int n) {

        // 处理细节问题
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(n == 3) return 4;
        int[] dp = new int[n + 1];// 创建dp表
        dp[1] = 1;dp[2] = 2;dp[3] = 4;// 初始化

        for(int i = 4; i <= n; i++) {// 填表
            dp[i] = (dp[i-1] + (dp[i-2] + dp[i-3]) % 1000000007) % 1000000007;

        }

        return dp[n];
    }
}
