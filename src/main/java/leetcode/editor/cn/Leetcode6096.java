package leetcode.editor.cn;

import java.util.Arrays;

public class Leetcode6096 {
    public static void main(String[] args) {
        Leetcode6096 leetcode6096 = new Leetcode6096();

    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < result.length; i++) {
            long current = spells[i];
            int left = 0;
            int right = potions.length;
            int currentIndex = -1;
            long tempResult = current * potions[potions.length - 1];
            if (tempResult < success) {
                result[i] = 0;
                continue;
            }
            tempResult = current * potions[0];
            if (tempResult >= success) {
                result[i] = potions.length;
                continue;
            }
            while(left <= right) {
                int mid = (left + right) / 2;
                long currentResult = current * potions[mid];
                if (currentResult >= success) {
                    right = mid - 1;
                    currentIndex = mid;
                } else {
                    left = mid + 1;
                }
            }
            result[i] = potions.length - currentIndex;
        }
        return result;
    }
}
