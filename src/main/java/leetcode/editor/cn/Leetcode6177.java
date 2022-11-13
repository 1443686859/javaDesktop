package leetcode.editor.cn;

import java.util.Arrays;

public class Leetcode6177 {
    public int partitionString(String s) {
        int result = 0;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int currentIndex = s.charAt(i) - 'a';
            if (count[currentIndex] != 0) {
                result ++;
                Arrays.fill(count, 0);
                i --;
            } else {
                count[currentIndex] ++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                result++;
                break;
            }
        }
        return result;
    }
}
