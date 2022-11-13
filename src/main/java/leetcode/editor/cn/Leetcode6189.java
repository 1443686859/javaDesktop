package leetcode.editor.cn;

public class Leetcode6189 {
    public static void main(String[] args) {
        Leetcode6189 leetcode6189 = new Leetcode6189();
        System.out.println(leetcode6189.longestSubarray(new int[]{96317,96317,96317,96317,96317,96317,96317,96317,96317,279979}));
    }
    public int longestSubarray(int[] nums) {
        int result = 1;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max <= nums[i]) {

              int tempResult = 1;
              int j = i + 1;
              while (j < nums.length && (nums[j] == nums[i])) {
                  j++;
                  tempResult++;
              }
              if (max == nums[i]) {
                  result = Math.max(result, tempResult);
              } else {
                  result = tempResult;
              }
              max = nums[i];
              i = j - 1;
            }
        }
        return result;
    }
}
