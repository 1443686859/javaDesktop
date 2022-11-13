package leetcode.editor.cn;

import java.util.Arrays;

public class Leetcode6064 {
    public static void main(String[] args) {
        Leetcode6064 leetcode6064 = new Leetcode6064();
        System.out.println(leetcode6064.maxConsecutive(6,8, new int[]{7,6,8}));
    }
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int result = 0;
        int start = bottom;
        int end = top;
        for (int i = 0; i < special.length; i++) {
            int current = special[i];
            int currentResult = 0;
            currentResult = current - start;
            start = current + 1;
            result = Math.max(result, currentResult);
        }
        if (start <= top) {
            result = Math.max(result, top - start + 1);
        }
        return result;
    }
}
