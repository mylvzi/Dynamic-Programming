package DP;

/**
 * 最大乘积
 */
public class Demo19 {
    class Solution {
        public int maxProduct(int[] nums) {
            int n = nums.length;
            int[] f = new int[n];
            int[] g = new int[n];

            f[0] = g[0] = nums[0];
            int max = f[0];
            for(int i = 1; i < n; i++) {
                int t1 = 0, t2 = 0;
                if(nums[i] > 0) {
                    f[i] = f[i - 1] * nums[i];
                    g[i] = g[i - 1] * nums[i];
                }else {
                    f[i] = g[i - 1] * nums[i];
                    g[i] = f[i - 1] * nums[i];
                }

                f[i] = Math.max(nums[i],f[i]);
                g[i] = Math.min(nums[i],g[i]);

                max = Math.max(f[i],max);
            }

            return max;
        }
    }
}
