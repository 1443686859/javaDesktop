package leetcode.editor.cn;

public class Leetcode5993 {
    public static void main(String[] args) {
        Leetcode5993 solution = new Leetcode5993();
        System.out.println(solution.findFinalValue(new int[]{161,28,640,264,81,561,320,2,61,244,183,108,773,61,976,122,988,2,370,392,488,375,349,432,713,563},61));
    }
    public int findFinalValue(int[] nums, int original) {
        if (original <= 0) {
            return original;
        }
        int[] count = new int[1001];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        while (original <= 1000 && count[original] != 0) {
            original <<= 1;
        }
        return original;
    }
}
