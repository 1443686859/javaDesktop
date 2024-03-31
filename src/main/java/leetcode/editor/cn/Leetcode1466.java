package leetcode.editor.cn;

import java.util.*;

public class Leetcode1466 {
    public int minReorder(int n, int[][] connections) {
        boolean[] used = new boolean[n];
        List<Integer>[] in = new ArrayList[n];
        List<Integer>[] out = new ArrayList[n];
        Arrays.setAll(in, e -> new ArrayList<>());
        Arrays.setAll(out, e -> new ArrayList<>());
        for (int[] c : connections) {
            out[c[0]].add(c[1]);
            in[c[1]].add(c[0]);
        }
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(0);
        used[0] = true;
        int count = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int current = deque.pollFirst();
                for (int j : out[current]) {
                    if (!used[j]) {
                        used[j] = true;
                        deque.addLast(j);
                    }
                }
                for (int j : in[current]) {
                    if (!used[j]) {
                        used[j] = true;
                        deque.addLast(j);
                        count++;
                    }

                }
            }
        }
        return n - count;
    }
}
