import java.util.Scanner;

public class Work1 {
    /**
     * 计算字符串中不含有重复字符的最长子串的长度
     *
     * @param s 输入的字符串
     * @return 不含有重复字符的最长子串的长度
     */
    public int lengthOfLongestSubstring(String s) {
        // 用于记录最长无重复子串的长度
        int max = 0;
        // 滑动窗口的左边界
        int left = 0;
        // 滑动窗口的右边界
        int right = 0;

        // 当右边界小于字符串长度时，继续扩展窗口
        while (right < s.length()) {
            // 获取当前右边界指向的字符
            char ch = s.charAt(right);  // charAt() 方法用于返回指定索引位置的字符。索引范围为从 0 到 length() - 1。
            // 在滑动窗口的左边界到右边界之间查找当前字符的位置
            int index = s.substring(left, right).indexOf(ch);  // substring() 方法返回字符串的子字符串。 indexOf() 方法返回字符串中第一次出现指定字符的索引。
            // 如果找到了重复字符
            if (index != -1) {
                // 修正左边界，跳过重复字符
                left = left + index + 1;
            }
            // 右边界右移一位，扩大窗口
            right++;
            // 更新最长无重复子串的长度
            max = Math.max(max, right - left);
        }
        // 返回最长无重复子串的长度
        return max;
    }

    public static void main(String[] args) {
        // 创建 Scanner 对象，用于从控制台读取输入
        Scanner sc = new Scanner(System.in);
        // 读取用户输入的一行字符串
        String s = sc.nextLine();
        // 创建 Work1 类的实例
        Work1 w = new Work1();
        // 调用 lengthOfLongestSubstring 方法计算最长无重复子串的长度并输出结果
        System.out.println(w.lengthOfLongestSubstring(s));
    }
}