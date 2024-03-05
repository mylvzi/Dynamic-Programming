package DP;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2024-01-18
 * Time: 20:27
 */
public class Demo1 {

    // 解法一:动态规划的思路
    // 状态表示  状态转移方程  初始化  填表顺序  返回值
    public int tribonacci(int n) {
        // 1.创建dp表
        // 2.初始化
        // 3.填表
        // 4.返回值

        // 处理细节问题
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 0; dp[1] = dp[2] = 1;
        for(int i = 3; i <= n; i++) {
            // 状态转移方程填表
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    // 解法2:使用滚动数组对动态规划做出空间优化  这种方法的空间复杂度为O(1)
    public int tribonacci2(int n) {
        if(n == 0) return 0;
        if(n == 1 ||n == 2) return 1;

        // 使用有限个变量来模拟dp表
        int a = 0, b = 1, c = 1, d = 0;
        for(int i = 3; i <= n; i++) {
            d = a + b + c;

            a = b;
            b = c;
            c = d;
        }

        return d;
    }
    public static void main(String[] args) {

    }
}
