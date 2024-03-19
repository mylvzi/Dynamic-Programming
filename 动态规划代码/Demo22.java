package DP;

/**
 * 湍流子数组的最大长度
 */
public class Demo22 {
    class Solution {
        public int maxTurbulenceSize(int[] arr) {
            int n = arr.length;

            // 1.创建dp表
            int[] f = new int[n];
            int[] g = new int[n];

            // 2.初始化为最次状态
            for(int i = 0; i < n; i++) f[i] = g[i] = 1;

            // 记录最值
            int m1 = 1, m2 = 1;

            // 3.填表
            for(int i = 1; i < n; i++) {
                int a = arr[i - 1], b = arr[i];

                f[i] = a < b ? g[i - 1] + 1 : 1;
                g[i] = a > b ? f[i - 1] + 1 : 1;

                m1 = m1 > f[i] ? m1 : f[i];
                m2 = m2 > g[i] ? m2 : g[i];
            }

            return m1 > m2 ? m1 : m2;
        }
    }
}
