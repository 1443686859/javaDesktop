package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode6262 {
    public static void main(String[] args) {
        Leetcode6262 leetcode6262 = new Leetcode6262();
        System.out.println(leetcode6262.maxStarSum(new int[]{1,2,3,4,10,-10,-20}, new int[][]{
                {0,1},{1,2},{1,3},{3,4},{3,5},{3,6}
        },1));
    }


    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int n = vals.length;
        List<Integer>[] grap = new List[n];
        for (int i = 0; i < n; i++) {
            grap[i] = new ArrayList();
        }
        for (int[] edge : edges) {
            grap[edge[0]].add(edge[1]);
            grap[edge[1]].add(edge[0]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int defaultValue = vals[i];
            int count = 1;
            Collections.sort(grap[i], (a, b) -> {
               return b - a;
            });
            for (int j = 0; j < grap[i].size() && count <= k; j++) {
                if (vals[grap[i].get(j)] > 0) {
                    count++;
                    defaultValue += vals[grap[i].get(j)];
                }
            }
            max = Math.max(max, defaultValue);
        }
        return max;

    }

}
