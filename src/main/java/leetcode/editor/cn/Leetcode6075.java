package leetcode.editor.cn;

import java.util.Arrays;

public class Leetcode6075 {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] restCount = new int[capacity.length];
        int count = 0;
        for (int i = 0; i < capacity.length; i++) {
            restCount[i] = capacity[i] - rocks[i];
            if (restCount[i] <= 0) {
                count++;
                restCount[i] = 0;
            }
        }
        Arrays.sort(restCount);
        int rest = additionalRocks;
        int startIndex = 0;
        while (rest > 0 && startIndex < capacity.length) {
            if (restCount[startIndex] != 0 && rest >= restCount[startIndex]) {
                rest -= restCount[startIndex];
                count++;
            }
            startIndex ++;
        }
        return count;
    }
}
