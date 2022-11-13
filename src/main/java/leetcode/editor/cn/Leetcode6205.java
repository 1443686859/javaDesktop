package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class Leetcode6205 {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> result = new HashSet<>();
        for (int i : nums) {
            result.add(i);
            result.add(get(i));
        }
        return result.size();
    }
    public int get(int i) {
        int tempResult = 0;
        while (i != 0) {
            int current = i % 10;
            tempResult = tempResult
                     * 10 + current;
            i /= 10;
        }
        return tempResult;
    }
}
