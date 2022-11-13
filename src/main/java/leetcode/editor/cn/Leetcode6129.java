package leetcode.editor.cn;

public class Leetcode6129 {
    public long zeroFilledSubarray(int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = i;
            while (current < nums.length && nums[current] == 0) {
                current++;
            }
            int currentLength = current - i;
            sum += 1l * (currentLength + 1) * currentLength / 2;
            i = current;
        }
        return sum;
    }

}
