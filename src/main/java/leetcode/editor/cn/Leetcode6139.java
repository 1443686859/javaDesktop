package leetcode.editor.cn;

import java.util.*;

public class Leetcode6139 {
    public static void main(String[] args) {
        Leetcode6139 leetcode6139 = new Leetcode6139();
        System.out.println(leetcode6139.reachableNodes(7, new int[][]{{0,1},{1,2},{3,1},{4,0},{0,5},{5,6}}, new int[]{4,5}));
    }
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        int[] visited = new int[n];
        for (int  i = 0 ; i < restricted.length; i++) {
            visited[restricted[i]] = -1;
        }
        if (visited[0] == -1) {
            return 0;
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] current = edges[i];
            if (visited[current[0]] == - 1 || visited[current[1]] == -1) {
                continue;
            }
            Set<Integer> list = map.getOrDefault(current[0], new HashSet<>());
            list.add(current[1]);
            map.put(current[0], list);

            Set<Integer> list1 = map.getOrDefault(current[1], new HashSet<>());
            list1.add(current[0]);
            map.put(current[1], list1);
        }
        int count = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(0);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int current = deque.poll();
                if (visited[current] == 1) {
                    continue;
                }
                visited[current] = 1;
                deque.addAll(map.getOrDefault(current, new HashSet<>()));
                count++;
            }
        }
        return count;
    }

}
