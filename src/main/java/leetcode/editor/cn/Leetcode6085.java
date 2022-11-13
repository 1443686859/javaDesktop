package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Leetcode6085 {
    public long maximumImportance(int n, int[][] roads) {
        int[] count = new int[n];
        for (int[] road : roads) {
            count[road[0]] ++;
            count[road[1]] ++;
        }
        long result = 0;
        Arrays.sort(count);
        long start = n;
        for (int i = n - 1; i >= 0; i--) {
            result += start * count[i];
            start--;
        }
        return result;
    }
}
