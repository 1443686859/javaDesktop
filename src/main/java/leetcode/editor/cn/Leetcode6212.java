package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Leetcode6212 {
    public boolean equalFrequency(String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                map.put(count[i], map.getOrDefault(count[i], 0) + 1);
            }
        }
        if (map.keySet().size() == 1 && map.containsKey(1)) {
            return true;
        } else if (map.keySet().size() > 2) {
            return false;
        } else if (map.keySet().size() == 2) {

            Integer[] array = new Integer[2];
            map.keySet().toArray(array);
            int min = Math.min(array[0], array[1]);
            int max = Math.max(array[0], array[1]);
            if (max - min == 1 && (map.get(max) == 1 || (map.get(min) == 1 && min == 1))) {
                return true;
            }
        }
        return false;
    }
}
