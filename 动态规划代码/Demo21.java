package DP;

/**
 * 等差数列子数组
 */
public class Demo21 {
    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            int n = nums.length;
            if(n == 0 || n == 1 || n == 2) return 0;

            // 1.创建dp表
            int[] dp = new int[n];

            // 2.初始化
            dp[0] = dp[1] = 0;
            // a,b,c表示相邻的三个数  sum用于求和
            int a = nums[0], b = nums[1], c = 0, sum = 0;

            // 3.填表
            for(int i = 2; i < n; i++) {
                c = nums[i];

                dp[i] = (c - b) == (b - a) ? (dp[i - 1] + 1) : 0;
                sum += dp[i];

                a = b;
                b = c;
            }

            return sum;
        }
    }
}
