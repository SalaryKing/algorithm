public class Work2 {
    /**
     * 此方法用于找出给定字符串中的最长回文子串
     * @param s 输入的字符串
     * @return 最长回文子串
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int n = s.length();
        // 初始化最长回文子串的起始位置和长度
        int start = 0;
        int maxLength = 1;
        // dp[i][j] 表示 s 的子串从 i 到 j 是否为回文串
        boolean[][] dp = new boolean[n][n];

        // 单个字符一定是回文串
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // 遍历所有子串长度，从2到 n
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;  // 子串结束下标
                if (s.charAt(i) == s.charAt(j)) {
                    // 长度为2的子串只需要两个字符相同即可
                    if (len == 2) {
                        dp[i][j] = true;
                    } else {
                        // 对于长度大于2的子串，当前字符相同且内部子串为回文
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }

                // 更新最长回文子串信息
                if (dp[i][j] && len > maxLength) {
                    maxLength = len;
                    start = i;
                }
            }
        }

        // 返回最长回文子串
        return s.substring(start, start + maxLength);
    }
}