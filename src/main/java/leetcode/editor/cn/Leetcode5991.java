package leetcode.editor.cn;

public class Leetcode5991 {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int startIndex = 0;
        int startIndex1 = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result[startIndex] = nums[i];
                startIndex+= 2;
            } else {
                result[startIndex1] = nums[i];
                startIndex1+= 2;
            }
        }
        return result;
    }
}
