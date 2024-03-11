package DP;

/**
 * 打家劫舍II
 * 此题变成了环形  唯一有影响的地方在于0位置对于最后一个位置的影响
 * 利用分类讨论(判断0位置的数字是否要选)  转换为限定区间的打家劫舍I
 */
public class Demo11 {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0],nums[1]);

        // 1.bums[0]不选
        int[] n1 = new int[n -3];
        for(int i = 0; i < n1.length; i++) n1[i] = nums[i + 2];
        int x = rob1(n1) + nums[0];

        int[] n2 = new int[n - 1];
        for(int i = 0; i < n2.length; i++) n2[i] = nums[i + 1];
        int y = rob1(n2);

        return x > y ? x : y;


    }

    private int rob1(int[] nums) {
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
