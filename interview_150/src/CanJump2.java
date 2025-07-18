public class CanJump2 {
    /**
     * 跳跃游戏2
     * 方法：贪心，反向查找出发位置
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int step = 0;
        int position = nums.length - 1;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    step++;
                    break;
                }
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new CanJump2().jump(nums));
    }
}
