package leetcode.editor.cn;

import jdk.internal.org.objectweb.asm.Handle;

import java.util.HashMap;
import java.util.Map;

public class Leetcode6092 {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < operations.length; i ++) {
            int index = map.get(operations[i][0]);
            map.remove(operations[i][0]);
            map.put(operations[i][1], index);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            nums[entry.getValue()] = entry.getKey();
        }
        return nums;
    }
}
