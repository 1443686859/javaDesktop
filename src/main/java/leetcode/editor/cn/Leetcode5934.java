package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode5934 {
    public int[] maxSubsequence(int[] nums, int k) {
        // 维持前k项
        List<Integer> result = new ArrayList<>();
        int count = nums.length - k;
        for (int i = 0; i < nums.length; i++) {
            int currentCount = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    
                }
            }
        }
        return null;
    }
}
