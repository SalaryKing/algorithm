public class MajorityElement {
    public int majorityElement(int[] nums) {
        // 初始化候选多数元素
        int candidate = nums[0];
        // 初始化候选元素的计数
        int count = 1;
        // 遍历数组
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                // 若计数为 0，更换候选元素
                candidate = nums[i];
                count = 1;
            } else if (nums[i] == candidate) {
                // 若当前元素等于候选元素，计数加 1
                count++;
            } else {
                // 若当前元素不等于候选元素，计数减 1
                count--;
            }
        }
        // 返回最终的候选元素，即多数元素
        return candidate;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        MajorityElement majorityElement = new MajorityElement();
        int k = majorityElement.majorityElement(nums);
        System.out.println(k);
    }
}
