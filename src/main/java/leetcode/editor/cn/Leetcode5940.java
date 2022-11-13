package leetcode.editor.cn;

public class Leetcode5940 {
    public static void main(String[] args) {
        Leetcode5940 solution = new Leetcode5940();
        System.out.println(solution.minimumDeletions(new int[]{101}));
    }
    public int minimumDeletions(int[] nums) {
        int max = 0;
        int min = 0;
        for (int i= 0; i < nums.length; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
            if (nums[i] < nums[min]) {
                min = i;
            }
        }
        int sameLeft = Math.max(min + 1, max + 1);
        int sameRight = Math.max(nums.length - max, nums.length - min);
        int minMax = Math.min(max + 1, nums.length - max);
        int minMin = Math.min(min + 1, nums.length - min);
        return Math.min(sameLeft, Math.min(sameRight, minMax + minMin));
    }
}
