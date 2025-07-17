/**
 * 该类用于解决与字符串相关的问题，这里主要是判断一个字符串是否由重复的子字符串构成。
 */
public class Work5 {
    /**
     * 判断一个字符串是否由重复的子字符串构成。
     *
     * 该方法使用了一种巧妙的算法，将原字符串拼接一次，然后在拼接后的字符串中从索引 1 开始查找原字符串。
     * 如果能找到且位置不等于原字符串的长度，说明原字符串是由重复的子字符串构成的。
     *
     * @param s 要判断的字符串
     * @return 如果字符串由重复的子字符串构成，返回 true；否则返回 false
     */
    // 重复的子字符串
    public boolean repeatedSubstringPattern(String s) {
        // 暴力解法：将字符串 s 拼接自身得到新字符串，从索引 1 开始查找 s
        // 如果找到的位置不等于 s 的长度，说明 s 是由重复子串构成
        return (s + s).indexOf(s, 1) != s.length();
    }

    /**
     * 程序的入口点，用于测试 repeatedSubstringPattern 方法。
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 目前主方法为空，可以在这里添加测试代码
        Work5 w = new Work5();
        System.out.println(w.repeatedSubstringPattern("abcd"));
        System.out.println(w.repeatedSubstringPattern("abcde"));
        System.out.println(w.repeatedSubstringPattern("abab"));
    }
}