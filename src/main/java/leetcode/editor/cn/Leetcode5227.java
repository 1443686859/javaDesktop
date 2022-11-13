package leetcode.editor.cn;

public class Leetcode5227 {
    public static void main(String[] args) {
        Leetcode5227 leetcode5227 = new Leetcode5227();
        System.out.println(leetcode5227.maximumTop(new int[]{35,43,23,86,23,45,84,2,18,83,79,28,54,81,12,94,14,0,0,29,94,12,13,1,48,85,22,95,24,5,73,10,96,97,72,41,52,1,91,3,20,22,41,98,70,20,52,48,91,84,16,30,27,35,69,33,67,18,4,53,86,78,26,83,13,96,29,15,34,80,16,49}, 15));
    }
    public int maximumTop(int[] nums, int k) {
        int n = nums.length;
        int max = - 1;
        if (n == 1 && k % 2 == 1) {
            return max;
        } else if (n == 1 && k % 2 == 0) {
            return nums[0];
        }
        if (k == 0) {
            return nums[0];
        }
        int count = 0;
        if (n + 1 <= k) {
            count = n + 1;
        } else {
            count = k;
        }
        int start = 0;
        for (int i = 0; i < count - 1; i++) {
            max = Math.max(max, nums[start++]);
        }
        int preMax = max;
        // 最后一步是删除还是添加
        if (start + 1 < n) {
            if (preMax >= nums[start + 1]) {
                max = preMax;
            } else {
                max = nums[start + 1];
            }
        }
        return max;
    }
}
