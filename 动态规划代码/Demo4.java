package DP;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 绿字
 * Date: 2024-01-26
 * Time: 11:02
 */

/**
 * 1.状态表示:dp[i] 表示以i位置为结尾,所有的解码方式的总和
 * 2.状态转移方程:从最近的一步考虑,要么是dp[i] 单独解码成功  要么是dp[i - 1] 与dp[i]共同解码成功
 * 3.初始化:就是为了防止越界  处理 0,1位置即可
 * 4.填表顺序  从左至右
 * 5.返回值 返回总的解码方式的个数  dp[n - 1]  字符串最后一个字符结尾的解码方式
 */
public class Demo4 {

    // 2.解法2  使用虚拟节点进行初始化的优化操作 将整个数组往后挪动一位
    // 注意事项有两个:
    // 1.dp[0] 的位置的值要保证能在后续填表过程中保证正确 此处dp[0] = 1 对应着s数组0,1位置共同解码的情况
    // 2.注意s的下表映射关系 dp的i对应着s中 i-1的值

    // 这种优化方式主要是考虑到解法1中对于dp[1]的初始化有些繁琐/重复
    // 考虑将dp[1]的初始化放到循环里面
    // 这种优化方式感觉就是为了代码好看一些
    public int numDecodings2(String ss) {
        char[] s = ss.toCharArray();
        int n = s.length;

        int[] dp = new int[n + 1];// 创建dp表

        dp[0] = 1;// 初始化dp[0]
        if(s[0] != '0') dp[1] = 1;
        if(n == 1) return dp[1];// 处理ss长度为1的边界情况


        // 填表
        for(int i = 2; i < n + 1; i++) {
            // 处理dp[i] 单独解码的情况
            if(s[i - 1] != '0') dp[i] += dp[i - 1];
            // 处理dp[i- 1] 与 dp[i] 共同解码的情况
            int tt = (s[i - 2] - '0')*10 + s[i - 1] - '0';
            if(tt >= 10 && tt <= 26) dp[i] += dp[i - 2];
        }

        return dp[n];
    }

    // 1.解法1 动态规划
    // 注意s[i]是介于'0' 和 '9'之间的一个字符 只要不是字符0,就可以解码成功
    // 对于前后两个位置共同解码的情况 需要将对应的字符转化为数字,要把得到的字符 - '0'才能正确转化为数字
    public int numDecodings3(String ss) {
        char[] s = ss.toCharArray();
        int n = s.length;

        int[] dp = new int[n];// 创建dp表

        if(s[0] != '0') dp[0] = 1;// 初始化dp[0]
        if(n == 1) return dp[0];// 处理ss长度为1的边界情况

        if(s[0] != '0' && s[1] != '0') dp[1] += 1;
        int t = (s[0] - '0')*10 + s[1] - '0';
        if(t >= 10 && t <= 26) dp[1] += 1;

        // 填表
        for(int i = 2; i < n; i++) {
            // 处理dp[i] 单独解码的情况
            if(s[i] != '0') dp[i] += dp[i - 1];
            // 处理dp[i- 1] 与 dp[i] 共同解码的情况
            int tt = (s[i - 1] - '0')*10 + s[i] - '0';
            if(tt >= 10 && tt <= 26) dp[i] += dp[i - 2];
        }

        return dp[n - 1];
    }

//    public static int numDecodings(String ss) {
//        char[] s = ss.toCharArray();
//        int n = s.length;
//
//        int[] dp = new int[n + 1];
//
//        // 初始化dp[0]
//        if(s[0] == '*') dp[0] = 9;
//        if(s[0] != '0' && s[0] != '*') dp[0] = 1;
//        if(n == 1) return dp[0];
//
//        // 初始化dp[1]
//        if(isLegalNumber(s[1])) dp[1] += dp[0];
//        if(s[1] == '*') dp[1] = dp[0] * 9;
//
//        if(s[1] != '*' && s[0] != '*') {
//            int tt = (s[0] - '0')*10 + s[1] - '0';
//            if(tt >= 10 && tt <= 26) dp[1] += dp[0];
//        }
//
//        if(s[0] == '*' && s[1] =='*'){
//            dp[1] += 15;
//        }
//
//        if(s[1] == '*' && isLegalNumber(s[0])) {
//            if(s[0] - '0' == 2) {
//                dp[1] += 6;
//            }else if(s[0] - '0' == 1) {
//                dp[1] += 9;
//            }else {
//                dp[1] += 0;
//            }
//        }
//
//        for(int i = 2; i < n; i++) {
//            if(isLegalNumber(s[i])) dp[i] += dp[i - 1];
//            if(s[i] == '*') dp[i] += dp[i - 1] * 9;
//
//            if(s[i] != '*' && s[i - 1] != '*') {
//                int tt = (s[i - 1] - '0')*10 + s[i] - '0';
//                if(tt >= 10 && tt <= 26) dp[i] += dp[i - 2];
//            }
//
//            if(s[i - 1] == '*' && s[i] =='*'){
//                dp[i] += dp[i - 2] * 15;
//            }
//
//            if(s[i] =='*' && isLegalNumber(s[i - 1])) {
//                if(s[i - 1] - '0' == 2) dp[i] += 6 * dp[i - 2];
//                if(s[i - 1] - '0' == 1) dp[i] += 9 * dp[i - 2];
//            }
//        }
//
//        return dp[n - 1] % (10 ^ 9 + 7);
//    }
//
//    private static boolean isLegalNumber(char sss) {
//        if(sss != '0' && sss != '*') return true;
//        return false;
//    }

//    public static void main(String[] args) {
//        String s= "**";
//        int ret = numDecodings(s);
//        System.out.println(ret);
//    }


}
