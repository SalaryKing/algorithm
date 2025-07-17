import java.util.Arrays;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 定义慢指针，指向当前不重复元素的最后一个位置
        int slow = 0;
        // 快指针遍历数组
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                // 找到不重复元素，慢指针后移一位
                slow++;
                // 将不重复元素放到慢指针位置
                nums[slow] = nums[fast];
            }
        }
        // 慢指针加 1 即为不重复元素的数量
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int k = removeDuplicates.removeDuplicates(nums);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));
    }
}
