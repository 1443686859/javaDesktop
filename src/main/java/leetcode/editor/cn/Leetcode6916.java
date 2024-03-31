package leetcode.editor.cn;


import java.util.*;

public class Leetcode6916 {
    public List<List<Integer>> findPrimePairs(int n) {
        boolean[] used = new boolean[n + 1];
        Arrays.fill(used, true);
        set(used, n);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 2; i <= n /2; i++) {
            if (used[i] && used[n - i]) {
                result.add(Arrays.asList(i, n - i));
            }
        }
        return result;
    }

    public void set(boolean[] used, int max) {
        List<Integer> prime = new ArrayList<>();
        for (int i = 2; i <= max; i++) {
            if (used[i]) {
                prime.add(i);
            }
            for (int j = 0; j <= prime.size() && i * prime.get(j) <= max; j++) {
                used[i * prime.get(j)] = false;
                if (i % prime.get(j) == 0) {
                    break;
                }
            }
        }
    }
}
