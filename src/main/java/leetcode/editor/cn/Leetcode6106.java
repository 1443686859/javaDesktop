package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Leetcode6106 {
    public static void main(String[] args) {
        Leetcode6106 leetcode6106 = new Leetcode6106();
        System.out.println(leetcode6106.countPairs(11,  new int[][]{
                {5,0},{1,0},{10,7},{9,8},{7,2},{1,3},{0,2},{8,5},{4,6},{4,2}}));
    }
    public long countPairs(int n, int[][] edges) {
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            count[i] = i;
        }
        for (int[] edge : edges) {
            match(edge[0], edge[1], count);
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int temp = i;
            while (temp != count[temp]) {
                temp = count[temp];
            }
            countMap.put(temp, countMap.getOrDefault(temp, 0) + 1);
        }
        long result =  0;
        for (int value : countMap.values()) {
           result += (n - value) * (long)value;
        }
        return result / 2;
    }
    public void match(int i, int j, int[] count) {
        while (i != count[i]) {
            i = count[i];
        }
        while (count[j] != j) {
            j = count[j];
        }
        if (i != j) {
            count[j] = i;
        }
    }
}
