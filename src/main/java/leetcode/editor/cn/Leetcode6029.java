package leetcode.editor.cn;

public class Leetcode6029 {
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        long max = 1 << 12;
        int maxCount = 0;
        int[] result = new int[12];
        for (long i = 0; i < max; i++) {
            int count = 0;
            int totalArrows = 0;
            int[] tempResult = new int[12];
            for (int j = 0; j < 12; j++) {
                if ((i >> j & 1)!= 0) {
                    count += j;
                    totalArrows += aliceArrows[j] + 1;
                    tempResult[j] = aliceArrows[j] + 1;
                }
            }
            if (totalArrows > numArrows) {
                continue;
            }
            if (count > maxCount) {
                maxCount = count;
                tempResult[0] += (numArrows - totalArrows);
                result = tempResult;
            }
        }
        return result;
    }

}
