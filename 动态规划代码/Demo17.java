package DP;

public class Demo17 {
    class Solution {
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            int dp = 0;
            int max = -0x3f3f3f3f;

            for(int num : nums) {
                dp = Math.max(num,dp + num);
                max = Math.max(max,dp);
            }

            return max;
        }
    }
}
