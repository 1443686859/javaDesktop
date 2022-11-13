package leetcode.editor.cn;

public class Leetcode6000 {
    public static void main(String[] args) {
        Leetcode6000 solution = new Leetcode6000();
        System.out.println(solution.sortEvenOdd(new int[]{2,1,1}));
    }
    public int[] sortEvenOdd(int[] nums) {
        int n = nums.length;
        for (int j = 0; j < n / 2; j ++) {
            for (int i = 0; i < n - 2; i+= 2) {
                if (nums[i] > nums[i + 2]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 2];
                    nums[i + 2] = temp;
                }
            }
        }
        for (int j = 0; j < n / 2; j ++) {
            for (int i = 1; i < n - 2; i+= 2) {
                if (nums[i] < nums[i + 2]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 2];
                    nums[i + 2] = temp;
                }
            }
        }
        return nums;
    }
}
