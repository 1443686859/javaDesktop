package leetcode.editor.cn;

public class Leetcode5236 {
    public static void main(String[] args) {
        Leetcode5236 leetcode5236 = new Leetcode5236();
        System.out.println(leetcode5236.minDeletion(new int[]{0,1,5,4,2,4,7,2,3,0,3,0,0,9,7,5,9,4,3,9,9,2,1,6,3,1,0,7,6,6,6,0,1,7,1,9,4,9,3,3,4,5,0,3,8,7,1,8,4,5}));
    }
    public int minDeletion(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if ((i - count) % 2 == 0) {
                int currentCount = 1;
                while ((i + currentCount < n) && nums[i] == nums[i + currentCount] ) {
                    nums[i + currentCount] = -1;
                    currentCount ++;
                }
                count = count + currentCount - 1;
                i+= currentCount - 1;
            }
        }
        if ((count & 1) == (n & 1)) {
            return count;
        } else  {
            return count + 1;
        }
    }
}
