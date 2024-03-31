package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Leetcode6297 {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (a, b) -> b[k] - a[k]);
        return score;
    }
}
