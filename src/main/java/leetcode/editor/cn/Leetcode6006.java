package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Leetcode6006 {
    public static void main(String[] args) {
        Leetcode6006 leetcode6006 = new Leetcode6006();
        System.out.println(leetcode6006.minimumRemoval(new int[]{66,90,47,25,92,90,76,85,22,3}));
    }
    long max = Integer.MAX_VALUE;
    public long minimumRemoval(int[] beans) {
        cycle(beans, 0, 0);
        return max;
    }
    public void cycle(int[] beans, int currentIndex, int currentResult) {
        if (currentIndex == beans.length) {
            if (check(beans)) {
                max = Math.min(max, currentResult);
            }
            return ;
        }
        if (currentResult > max) {
            return;
        }
        int currentMax = beans[currentIndex];
        for (int i = 0; i <= currentMax; i++) {
            beans[currentIndex] -= i;
            cycle(beans, currentIndex + 1, currentResult + i);
            beans[currentIndex] += i;
        }
        return;
    }
    public boolean check(int[] beans) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < beans.length; i++) {
            countMap.put(beans[i], countMap.getOrDefault(beans[i], 0) + 1);
        }
        if (countMap.containsKey(0)) {
            return countMap.keySet().size() <= 2;
        } else {
            return countMap.keySet().size() == 1;
        }
    }
}
