package DP;

/**
 * 乘积为正数的最大子数组
 */
public class Demo20 {
    class Solution {
        public int getMaxLen(int[] nums) {
            int n = nums.length;

            // 1.创建dp表
            int[] f = new int[n];
            int[] g = new int[n];

            // 2.根据状态表示进行初始化
            f[0] = nums[0] > 0 ? 1 : 0;
            g[0] = nums[0] < 0 ? 1 : 0;

            int max = -0x3f3f3f3f;

            // 3.填表
            for(int i = 1; i < n; i++) {
                if(nums[i] > 0) {
                    f[i] = f[i - 1] + 1;
                    g[i] = g[i - 1] == 0 ? 0 : g[i - 1] + 1;
                }else if(nums[i] < 0){
                    f[i] = g[i - 1] == 0 ? 0 : g[i - 1] + 1;
                    g[i] = f[i - 1] + 1;
                }else {
                    f[i] = g[i] = 0;// 注意等于0相当于直接截断 要重新计数 从0开始
                }

                max = Math.max(f[i],max);// 更新长度
            }

            // 处理n == 1的情况
            return max == -0x3f3f3f3f ? f[0] : max;
        }
    }
}
