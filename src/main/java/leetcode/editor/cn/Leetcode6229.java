package leetcode.editor.cn;

public class Leetcode6229 {
    public static void main(String[] args) {
        Leetcode6229 Leetcode6229 = new Leetcode6229();
        System.out.println(Leetcode6229.applyOperations(new int[]{847,847,0,0,0,399,416,416,879,879,206,206,206,272}));
    }
    public int[] applyOperations(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1] && nums[i] != 0) {
                nums[index] = 2 * nums[i];
                nums[i + 1] = 0;
                index++;
            } else if (nums[i] != 0){
                nums[index] = nums[i];
                index++;
            }
        }
        if (nums[nums.length - 1] != 0) {
            nums[index++] = nums[nums.length - 1];
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
        return nums;
    }
}
