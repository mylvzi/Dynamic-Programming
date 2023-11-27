/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2023-11-27
 * Time: 23:43
 */
public class Test1 {
//    class Solution {
//        public int tribonacci(int n) {
//            // 1.创建dp表
//            // 2.初始化(防止越界)
//            // 3.填表
//            // 4.返回
//
//            // 处理细节
//            if(n == 0) return 0;
//            if(n == 1 || n == 2) return 1;
//
//            int[] dp = new int[n+1];
//            dp[0]=0;dp[1]=dp[2]=1;
//            for(int i = 3; i <= n; i++) {
//                // 状态转移方程+填表顺序
//                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
//            }
//            return dp[n];
//
//        }
//    }
//
//    // 空间优化
//    class Solution {
//        public int tribonacci(int n) {
//            // 1.创建dp表
//            // 2.初始化(防止越界)
//            // 3.填表
//            // 4.返回
//
//            // 处理细节
//            if(n == 0) return 0;
//            if(n == 1 || n == 2) return 1;
//
//            int a=0,b=1,c=1,d=0;
//            for(int i = 3; i <= n; i++) {
//                // 状态转移方程+填表顺序
//                d = a+b+c;
//                a = b;
//                b = c;
//                c = d;
//            }
//            return d;
//
//        }
//    }
}
