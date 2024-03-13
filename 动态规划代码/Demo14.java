package DP;

/**
 * 删除并获得点数
 * 转化为打家劫舍问题
 */
public class Demo14 {
    class Solution {
        public int deleteAndEarn(int[] nums) {
            // 转化为打家劫舍问题
            Arrays.sort(nums);
            int n = nums[nums.length - 1] + 1;
            // 创建数组来统计nums中的每个数字的和
            int[] arr = new int[n];

            // 赋值arr
            for(int i = 0; i < nums.length; i++) {
                int index = nums[i];
                arr[index] += nums[i];
            }

            // 转化为打家劫舍问题
            // 创建dp表
            int[] f = new int[n];
            int[] g = new int[n];

            // 初始化
            f[0] = arr[0];g[0] = 0;

            // 填表
            for(int i = 1; i < n; i++) {
                f[i] = g[i - 1] + arr[i];// arr[i]必选
                g[i] = Math.max(f[i - 1],g[i - 1]);// arr[i]不选
            }

            // 返回值
            return f[n - 1] > g[n - 1] ? f[n - 1] : g[n - 1];

        }
    }
}
