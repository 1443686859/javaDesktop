package leetcode.editor.cn;

import java.util.Arrays;

public class Leetcode6169 {
    public static void main(String[] args) {
        Leetcode6169 leetcode6169 = new Leetcode6169();
        System.out.println(leetcode6169.longestNiceSubarray(new int[]{84139415,693324769,614626365,497710833,615598711,264,65552,50331652,1,1048576,16384,544,270532608,151813349,221976871,678178917,845710321,751376227,331656525,739558112,267703680}));
    }
    public int longestNiceSubarray(int[] nums) {
        int result = 1;
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            boolean temp = true;
            int tempResult = 0;
            for (int j = i - 1; j >= i - dp[i - 1]; j--) {
                if (((long)nums[j] & (long)nums[i]) != 0) {
                    temp = false;
                    break;
                }
                tempResult++;
            }
            if (temp) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = tempResult + 1;
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
