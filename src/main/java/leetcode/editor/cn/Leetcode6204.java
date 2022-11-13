package leetcode.editor.cn;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;

public class Leetcode6204 {
    public int findMaxK(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = -1;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if (map.containsKey( - i)) {
                result = Math.max(result, Math.abs(i));
            }
        }
        return result;
    }
}
