import java.util.Arrays;

public class MergeArray {
    /**
     * 合并两个按非递减顺序排列的整数数组 nums1 和 nums2 到 nums1 中
     *
     * @param nums1 第一个数组，长度为 m + n
     * @param m     nums1 中实际元素的数目
     * @param nums2 第二个数组，长度为 n
     * @param n     nums2 中元素的数目
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 定义三个指针，p1 指向 nums1 实际元素的末尾，p2 指向 nums2 的末尾，p 指向合并后数组的末尾
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        // 从后往前遍历，比较 nums1 和 nums2 的元素，将较大的元素放到 nums1 的末尾
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        // 如果 nums2 还有剩余元素，将其依次复制到 nums1 的前面
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        MergeArray mergeArray = new MergeArray();

        int m = 3;
        int n = 3;
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        mergeArray.merge(nums1, m, nums2, n);
    }
}
