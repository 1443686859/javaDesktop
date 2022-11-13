package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode6224 {
    public int subarrayGCD(int[] nums, int k) {
        List<Set<Integer>> list = new ArrayList<>();
        boolean[] con = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {

        }
        return 0;
    }
    public Set<Integer> get(int num) {
        int max = (int)(Math.sqrt(num));
        Set<Integer> result = new HashSet<>();
        for (int i = 1; i <= max; i++) {
            if ((num % i) == 0) {
                result.add(num / i);
                result.add(i);
            }
        }
        return  result;
    }
}
