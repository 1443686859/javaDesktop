package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode6255 {
    public static void main(String[] args) {
        Leetcode6255 leetcode6255 = new Leetcode6255();
        System.out.println(leetcode6255.minScore(13, new int[][]{{2,12,1891},{10,9,4138},{11,3,2007},{1,10,9390},{12,8,1915},{6,2,1098},{5,4,2795},{3,13,4562},{9,7,9202},{4,6,6752},{8,11,1480},{7,5,9827}}));
    }
    int result;
    public int minScore(int n, int[][] roads) {
        int[] count = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            count[i] = i;
        }
        Arrays.sort(roads, (a, b) -> {
            if (Math.min(a[1], a[0]) - Math.min(b[1],b[0]) == 0) {
                return Math.max(a[1], a[0]) - Math.max(b[1],b[0]);
            }
            return Math.min(a[1], a[0]) - Math.min(b[1],b[0]);
        });

        result = Integer.MAX_VALUE;
        for (int i = 0; i < roads.length; i++) {
            int[] road = roads[i];
            merge(Math.min(road[1], road[0]), Math.max(road[1], road[0]), count);
        }
        for (int i = 0 ; i < roads.length; i++) {
            int[] road = roads[i];
            if (getParent(road[0],count) == 1 || getParent(road[1],count) == 1) {
                result = Math.min(result, road[2]);
            }
        }
        return result;
    }
    public void merge(int i , int j, int[] count) {
        int parentI = getParent(i, count);
        int parentJ = getParent(j, count);
        if (parentI != parentJ) {
            int index = -1;
            int target = -1;
            if (parentI > parentJ) {
                index = i;
                target = parentJ;
            } else {
                index = j;
                target = parentI;
            }

            while (index != count[index]) {
                index = count[index];
                count[index] = target;
            }
            count[index] = target;
        }
    }
    public int getParent(int i, int[] count) {

        if (i != count[i]) {
            count[i] = getParent(count[i], count);
        }
        return count[i];
    }
}
