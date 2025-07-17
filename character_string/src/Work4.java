/**
 * 该类包含一个用于在字符串中查找子字符串首次出现位置的方法，使用 KMP 算法优化。
 */
public class Work4 {
    /**
     * 利用 KMP 算法优化暴力匹配，找出字符串中第一个匹配项的下标。
     *
     * @param haystack 要搜索的字符串
     * @param needle   要查找的子字符串
     * @return 如果找到匹配项，返回其在 haystack 中的起始下标；若未找到，返回 -1
     */
    public static int strStr(String haystack, String needle) {
        // 创建 next 数组，用于记录模式串（needle）中每个位置之前的子串的最长公共前后缀长度
        int[] next = new int[needle.length()];
        // i 用于遍历模式串（needle）
        int i = 0;
        // j 用于记录最长公共前后缀的长度
        int j = -1;
        // 初始化 next 数组的第一个元素为 -1
        next[0] = -1;

        // 构建 next 数组
        while (i < needle.length() - 1) {
            // 当 j 为 -1 或者当前字符匹配时
            if (j == -1 || needle.charAt(i) == needle.charAt(j)) {
                // 移动到下一个字符
                i++;
                // 最长公共前后缀长度加 1
                j++;
                // 将当前位置的最长公共前后缀长度记录到 next 数组中
                next[i] = j;
            } else {
                // 若不匹配，回溯 j 的位置
                j = next[j];
            }
        }

        // 重置 i 和 j，用于字符串匹配过程
        i = 0;
        j = 0;

        // 进行字符串匹配
        while (i < haystack.length() && j < needle.length()) {
            // 当 j 为 -1 或者当前字符匹配时
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                // 移动到下一个字符
                i++;
                // 模式串指针后移
                j++;
            } else {
                // 若不匹配，根据 next 数组回溯 j 的位置
                j = next[j];
            }
        }

        // 如果模式串全部匹配完
        if (j == needle.length()) {
            // 返回匹配项在 haystack 中的起始下标
            return i - j;
        } else {
            // 若未找到匹配项，返回 -1
            return -1;
        }
    }

    /**
     * 程序的入口点，用于测试 strStr 方法。
     *
     * @param args 命令行参数，在本程序中未使用
     */
    public static void main(String[] args) {
        // 测试 strStr 方法
        String haystack = "hello world";
        String needle = "world";
        int result = strStr(haystack, needle);
        if (result != -1) {
            System.out.println("子字符串 \"" + needle + "\" 在 \"" + haystack + "\" 中首次出现的下标是: " + result);
        } else {
            System.out.println("子字符串 \"" + needle + "\" 未在 \"" + haystack + "\" 中找到。");
        }
    }
}