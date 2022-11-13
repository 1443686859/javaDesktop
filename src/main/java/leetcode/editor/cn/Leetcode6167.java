package leetcode.editor.cn;

import java.util.Arrays;

public class Leetcode6167 {
    public boolean checkDistances(String s, int[] distance) {
        int[] array = new int[26];
        Arrays.fill(array, -1);
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (array[index] != -1) {
                array[index] = i - array[index] - 1;
                if (array[index] != distance[index]) {
                    return false;
                }
            } else {
                array[index] = i;
            }
        }
        return true;
    }
}
