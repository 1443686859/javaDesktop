package leetcode.editor.cn;

import java.util.Arrays;

public class Leetcode6076 {
    public int minimumLines(int[][] stockPrices) {
        if (stockPrices.length < 2) {
            return 0;
        }
        Arrays.sort(stockPrices, (a, b) ->{
            return a[0] - b[0];
        });
        int[] prePoints = stockPrices[0];
        double startRadix = getRadix(prePoints, stockPrices[1]);
        int result = 1;
        for (int i = 1; i < stockPrices.length; i++) {
            double currentRadix = getRadix(prePoints, stockPrices[i]);
            if (currentRadix != startRadix) {
                result ++;
            }
            startRadix = currentRadix;
            prePoints = stockPrices[i];
        }
        return result;
    }
    public double getRadix(int[] pre, int[] current) {
        return (double)(current[1] - pre[1]) / (current[0] - pre[0]);
    }
}
