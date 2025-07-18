import java.util.Arrays;

public class Rotate {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] out = new int[len];
        for (int i = 0; i < len; i++) {
            out[(i + k) % len] = nums[i];
        }
        System.arraycopy(out,0,nums,0,len);
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        Rotate rotate = new Rotate();
        rotate.rotate(nums,k);
    }
}
