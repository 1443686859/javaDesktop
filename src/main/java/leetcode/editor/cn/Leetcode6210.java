package leetcode.editor.cn;

public class Leetcode6210 {
    public static void main(String[] args) {

    }
    public int minimizeArrayValue(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = Math.max(result, nums[i]);
        }
        int currentResult = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                int tempResult = nums[i] + nums[i - 1];
                tempResult = (tempResult / 2) + (((tempResult & 1) != 0) ? 1 : 0);
                if (currentResult == 0) {
                    currentResult = tempResult;
                } else {
                    currentResult = Math.max(tempResult, currentResult);
                }
            }
        }
        return currentResult == 0 ? result : Math.min(currentResult, result);
    }
}
