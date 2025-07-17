import java.util.Arrays;

public class RemoveDuplicates2 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        // 定义慢指针，指向当前符合条件元素的最后一个位置
        int slow = 2;
        // 快指针遍历数组
        for (int fast = 2; fast < nums.length; fast++) {
            // 若当前元素和慢指针前两个位置的元素不相等
            if (nums[fast] != nums[slow - 2]) {
                // 将符合条件的元素放到慢指针位置
                nums[slow] = nums[fast];
                // 慢指针后移一位
                slow++;
            }
        }
        // 慢指针即为符合条件元素的数量
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        RemoveDuplicates2 removeDuplicates2 = new RemoveDuplicates2();
        int k = removeDuplicates2.removeDuplicates(nums);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));
    }
}
