package DP;

/**
 * 环形子数组和
 */
public class Demo18 {
    class Solution {
        public int maxSubarraySumCircular(int[] nums) {
            int n = nums.length;
            if(n == 1) return nums[0];
            int[] f = new int[n];
            int[] g = new int[n];

            f[0] = g[0] = nums[0];
            int max = -0x3f3f3f3f;
            int min = 0x3f3f3f3f;
            int sum = nums[0];
            for(int i = 1; i < n; i++) {
                f[i] = Math.max(nums[i],f[i - 1] + nums[i]);
                g[i] = Math.min(nums[i],g[i - 1] + nums[i]);

                max = Math.max(max,f[i]);
                min = Math.min(min,g[i]);

                sum += nums[i];
            }

            return sum == min ? max : Math.max(max,sum - min);
        }
    }
}
