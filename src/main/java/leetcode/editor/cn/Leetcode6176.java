package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode6176 {
    public static void main(String[] args) {
        Leetcode6176 leetcode6176 = new Leetcode6176();
        System.out.println(leetcode6176.mostFrequentEven(new int[]{0,1,2,2,4,4,1}));
    }
    public int mostFrequentEven(int[] nums) {
        int max = 0;
        int result = -1;
        Arrays.sort(nums);
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : nums) {
            if ((i & 1) == 0) {
                countMap.put(i, countMap.getOrDefault(i, 0) + 1);
                if (countMap.get(i) > max) {
                    max = countMap.get(i);
                    result = i;
                }
            }
        }
        return result;
    }
}
