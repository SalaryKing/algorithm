/**
 * 该类包含一个用于计算长度最小的子数组的方法
 */
public class Work1 {
    /**
     * 计算总和大于等于目标值的最短连续子数组的长度
     *
     * @param target 目标总和
     * @param nums   输入的整数数组
     * @return 满足条件的最短子数组的长度，如果没有找到则返回 0
     */
    public int minSubArrayLen(int target, int[] nums) {
        // 定义滑动窗口的左边界
        int left = 0;
        // 定义滑动窗口的右边界
        int right = 0;
        // 记录当前滑动窗口内元素的总和
        int sum = 0;
        // 初始化最小长度为最大整数，用于后续比较更新
        int minLength = Integer.MAX_VALUE;

        // 开始移动右边界，扩大窗口，直到遍历完整个数组
        while (right < nums.length) {
            // 累加当前右边界元素到总和中
            sum += nums[right];
            // 右边界右移一位
            right++;
            // 当窗口内元素总和大于等于目标值时，尝试缩小窗口
            while (sum >= target) {
                // 计算当前窗口的长度
                int currentLength = right - left;
                // 更新最小长度
                minLength = Math.min(minLength, currentLength);
                // 从总和中减去左边界元素
                sum -= nums[left];
                // 左边界右移一位
                left++;
            }
        }

        // 如果没有找到符合条件的子数组，返回 0
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    /**
     * 程序的入口点，用于测试 minSubArrayLen 方法
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 创建 Work1 类的实例
        Work1 work = new Work1();
        // 设定目标总和
        int target = 7;
        // 定义输入的整数数组
        int[] nums = {2, 3, 1, 2, 4, 3};
        // 调用 minSubArrayLen 方法计算结果
        int result = work.minSubArrayLen(target, nums);
        // 输出结果
        System.out.println("满足条件的最短子数组的长度是: " + result);
    }
}