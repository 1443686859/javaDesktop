package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode6360 {
    public int minImpossibleOR(int[] nums) {
        Arrays.sort(nums);
        List<Integer> currentList = new ArrayList<>();
        for (int i : nums) {
            if (check(i)) {
                currentList.add(i);
            }
        }
        int result = 1;
        while (currentList.contains(result)) {
            result <<= 1;
        }
        return result;
    }
    public boolean check(int i) {
        return (i & (i - 1)) == 0;
    }

}
