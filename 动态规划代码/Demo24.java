package DP;

public class Demo24 {
    class Solution {
        public int findSubstringInWraproundString(String s) {
            // 转换为字符数组
            char[] ss = s.toCharArray();
            int n = s.length();
            if(n == 1) return 1;

            // 创建dp表
            int[] dp = new int[n];
            for(int i = 0; i < n; i++) dp[i] = 1;// 初始化为最次状态1

            // 用于解决重复子串的数组
            // 记录以xx字符结尾时的最大值
            int[] cnt = new int[26];
            cnt[ss[0] - 'a'] = 1;

            // 填表
            for(int i = 1; i < n; i++) {
                if(ss[i - 1] + 1 == ss[i] || (ss[i - 1] == 'z' && ss[i] == 'a')) {
                    dp[i] += dp[i - 1];
                }

                // 更新最值
                cnt[ss[i]-'a'] = Math.max(cnt[ss[i] - 'a'],dp[i]);
            }

            // 求和
            int ret = 0;
            for(int x : cnt) ret += x;

            return ret;
        }
    }
}
