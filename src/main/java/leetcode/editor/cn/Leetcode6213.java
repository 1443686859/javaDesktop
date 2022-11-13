package leetcode.editor.cn;

public class Leetcode6213 {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int result1 = 0;
        for (int nums : nums1) {
            result1 ^= nums;
        }
        int result = 0;
        for (int i = 0; i < nums2.length; i++) {
            result ^= ((nums1.length & 1) == 0 ? 0 : nums2[i]) ^ result1;
        }
        return result;
    }
}
