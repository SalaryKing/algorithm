import java.util.Arrays;

public class RemoveElement {
    /**
     * 原地移除数组中所有等于 val 的元素，并返回剩余元素的数量。
     *
     * @param nums 输入的整数数组
     * @param val  需要移除的值
     * @return 移除指定值后数组中剩余元素的数量
     */
    public int removeElement(int[] nums, int val) {
        // 用于记录不等于 val 的元素的索引
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果当前元素不等于 val，则将其放到数组的前 k 个位置
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        // 返回不等于 val 的元素的数量
        return k;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        RemoveElement removeElement = new RemoveElement();
        int k = removeElement.removeElement(nums, val);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));
    }
}
