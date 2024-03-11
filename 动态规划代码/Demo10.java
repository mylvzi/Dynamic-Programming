package DP;

// 多状态问题  按摩师
public class Demo10 {
    public int massage(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;

        // 创建dp表
        int[] f = new int[n];
        int[] g = new int[n];

        // 初始化
        f[0] = nums[0];g[0] = 0;

        // 填表
        for(int i = 1; i < n; i++) {
            f[i] = g[i - 1] + nums[i];// nums[i]必选
            g[i] = Math.max(f[i - 1],g[i - 1]);// nums[i]不选
        }

        // 返回值
        return f[n - 1] > g[n - 1] ? f[n - 1] : g[n - 1];
    }
}
