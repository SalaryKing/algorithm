import java.util.Arrays;

public class Work6 {
    public boolean repeatedSubstringPattern(String s) {
        // 调用 kmp 方法在 s + s 中查找 s
        return kmp(s + s, s);
    }

    /**
     * KMP（Knuth-Morris-Pratt）算法，用于在 query 字符串中查找 pattern 字符串
     *
     * @param query   要搜索的主字符串
     * @param pattern 要查找的模式字符串
     * @return 如果找到模式字符串返回 true，否则返回 false
     */
    public boolean kmp(String query, String pattern) {
        // 获取主字符串的长度
        int n = query.length();
        // 获取模式字符串的长度
        int m = pattern.length();
        // 创建一个长度为 m 的数组 fail，用于记录模式字符串的最长公共前后缀
        int[] fail = new int[m];
        // 将 fail 数组的所有元素初始化为 -1
        Arrays.fill(fail, -1);
        // 构建 fail 数组，用于记录模式字符串每个位置的最长公共前后缀
        for (int i = 1; i < m; ++i) {
            // 获取前一个位置的最长公共前后缀长度
            int j = fail[i - 1];
            // 当 j 不为 -1 且当前字符与前一个位置的最长公共前后缀的下一个字符不相等时
            while (j != -1 && pattern.charAt(j + 1) != pattern.charAt(i)) {
                // 回溯 j 的值
                j = fail[j];
            }
            // 如果当前字符与前一个位置的最长公共前后缀的下一个字符相等
            if (pattern.charAt(j + 1) == pattern.charAt(i)) {
                // 更新当前位置的最长公共前后缀长度
                fail[i] = j + 1;
            }
        }
        // 初始化匹配位置为 -1
        int match = -1;
        // 遍历主字符串
        for (int i = 1; i < n - 1; ++i) {
            // 当匹配位置不为 -1 且当前字符与模式字符串中匹配位置的下一个字符不相等时
            while (match != -1 && pattern.charAt(match + 1) != query.charAt(i)) {
                // 回溯匹配位置
                match = fail[match];
            }
            // 如果当前字符与模式字符串中匹配位置的下一个字符相等
            if (pattern.charAt(match + 1) == query.charAt(i)) {
                // 匹配位置加 1
                ++match;
                // 如果匹配位置达到模式字符串的长度减 1，说明找到了模式字符串
                if (match == m - 1) {
                    return true;
                }
            }
        }
        // 没有找到模式字符串，返回 false
        return false;
    }

    /**
     * 程序的入口点，用于测试 repeatedSubstringPattern 方法
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 创建 Work6 类的实例
        Work6 work6 = new Work6();
        // 定义测试字符串
        String testString = "abab";
        // 调用 repeatedSubstringPattern 方法判断测试字符串是否由重复子串构成
        boolean result = work6.repeatedSubstringPattern(testString);
        // 使用 result 变量，输出结果
        System.out.println("字符串 \"" + testString + "\" 是否由重复子串构成: " + result);
    }
}