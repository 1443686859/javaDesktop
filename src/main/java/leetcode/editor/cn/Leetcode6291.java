package leetcode.editor.cn;

public class Leetcode6291 {
    public int differenceOfSum(int[] nums) {
        int sum = 0;
        int sum2 = 0;
        for (int i : nums) {
            sum2 += get(i);
            sum += i;
        }
        return Math.abs(sum2 - sum);
    }
    public int get(int num) {
        int result = 0;
        while (num != 0) {
            result += num % 10;
            num /= 10;
        }
        return result;
    }
}
