/**
 * 该类包含一个用于查找字符串中第一个匹配项下标的方法。
 */
public class Work3 {
    /**
     * 找出字符串中第一个匹配项的下标。
     * 算法：朴素模式匹配算法(暴力算法)
     *
     * @param haystack 要搜索的字符串。
     * @param needle 要查找的子字符串。
     * @return 如果找到匹配项，返回其在 haystack 中的起始下标；否则返回 -1。
     */
    public int strStr(String haystack, String needle) {
        // 获取 haystack 字符串的长度
        int n = haystack.length();
        // 获取 needle 字符串的长度
        int m = needle.length();
        // 初始化 haystack 的索引
        int i = 0;
        // 初始化 needle 的索引
        int j = 0;
        // 当 haystack 和 needle 都未遍历完时，继续循环
        while (i < n && j < m) {
            // 如果当前字符匹配
            if (haystack.charAt(i) == needle.charAt(j)) {
                // 移动到 haystack 的下一个字符
                i++;
                // 移动到 needle 的下一个字符
                j++;
            }
            // 如果当前字符不匹配
            else {
                // 回溯 haystack 的索引
                i = i - j + 1;
                // 重置 needle 的索引
                j = 0;
            }
        }
        // 如果 needle 已经全部匹配
        if (j == m) {
            // 返回匹配的起始下标
            return i - j;
        }
        // 如果没有找到匹配项
        else {
            // 返回 -1
            return -1;
        }
    }
    /**
     * 程序的入口点，用于测试 strStr 方法。
     *
     * @param args 命令行参数，在本程序中未使用。
     */
    public static void main(String[] args) {
        // 创建 Work3 类的实例
        Work3 work3 = new Work3();
        // 调用 strStr 方法并打印结果
        System.out.println(work3.strStr("hello", "world"));
    }
}