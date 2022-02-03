package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leetcode5978 {
    public int wordCount(String[] startWords, String[] targetWords) {
        Set<String> set = new HashSet<>();
        for (String start : startWords) {
            char[] chars = start.toCharArray();
            Arrays.sort(chars);
            set.add(new String(chars));
        }
        int res = 0;
        for (String target : targetWords) {
            char[] chars = target.toCharArray();
            Arrays.sort(chars);
            String newTarget = new String(chars);
            for (int i = 0; i < newTarget.length(); i++) {
                String cur = newTarget.substring(0, i) + newTarget.substring(i + 1);
                if (set.contains(cur)) {
                    res++;
                    break;
                }
            }

        }
        return res;
    }
}
