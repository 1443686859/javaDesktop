package leetcode.editor.cn;

import java.util.*;

public class Leetcode6248 {
    public static void main(String[] args) {
        Leetcode6248 leetcode6248 = new Leetcode6248();
        System.out.println(leetcode6248.countSubarrays(new int[]{4,1,3,2}, 1));
    }
    public int countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int index = -1;
        int current = 0;
        int result = 0;
        int[] countArray = new int[2 * n + 2];
        int[] count = new int[n];
        countArray[n] = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > k) {
                current++;
            } else if (nums[i] == k) {
                index = i;
            } else {
                current--;
            }
            count[i] = current;
            if (index == -1) {
                 countArray[count[i] + n]++;
            }
        }
        result = countArray[count[index] - 1 + n] + countArray[count[index] + n];
        for (int i = index + 1; i < n; i++) {
            result += countArray[count[i] - 1 + n] + countArray[count[i] + n];
        }
        return result;
    }
}
