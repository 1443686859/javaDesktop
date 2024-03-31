package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

public class Leetcode6315 {
    public int vowelStrings(String[] words, int left, int right) {
        int n = words.length;
        List<Character> list = Arrays.asList('a','e','i','o','u');
        int[] count = new int[n + 1];
        for (int i = 0; i < n; i++) {
            count[i + 1] = count[i];
            if (list.contains(words[i].charAt(0)) && list.contains(words[i].charAt(words[i].length() - 1))) {
                count[i + 1]++;
            }
        }
        return count[right + 1] -count[left];
    }
}
