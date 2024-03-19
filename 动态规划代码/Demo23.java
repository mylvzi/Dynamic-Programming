package DP;

/**
 * 单词拆分
 */
public class Demo23 {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {

            Set<String> hash = new HashSet<>(wordDict);

            int n = s.length();
            boolean[] dp = new boolean[n + 1];
            dp[0] = true;
            s = " " + s;

            for(int i = 1;i <= n; i++) {
                for(int j = i; j >= 1; j--) {
                    if(dp[j - 1] == true && hash.contains(s.substring(j,i + 1))) {
                        dp[i] = true;
                        break;// 找到正确的情况
                    }
                }
            }

            return dp[n];

        }
    }
}
