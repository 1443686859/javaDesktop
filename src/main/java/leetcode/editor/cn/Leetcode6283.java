package leetcode.editor.cn;

public class Leetcode6283 {
    public int maximumCount(int[] nums) {
        int neg = 0;
        int pos = 0;
        for (int i : nums) {
            if (i > 0) {
                pos++;
            }
            if (i < 0) {
                neg++;
            }
        }
        return Math.max(pos, neg);
    }
}
