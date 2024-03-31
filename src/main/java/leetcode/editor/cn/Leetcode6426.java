package leetcode.editor.cn;

import java.util.Arrays;

public class Leetcode6426 {
    int mod = (int)1e9 + 7;
    public int sumDistance(int[] nums, String s, int d) {

        int[][] numsD = new int[s.length()][2];
        for (int i = 0; i < s.length(); i++) {
            numsD[i][0] = nums[i];
            numsD[i][1] = s.charAt(i) == 'L' ? - 1 : 1;
        }
        Arrays.sort(numsD, (pre, after) -> {
            return pre[0] - after[0];
        });
        return 0;
    }
}
