package leetcode.editor.cn;

import java.util.*;

public class Leetcode6243 {
    public static void main(String[] args) {
        Leetcode6243 leetcode6243 = new Leetcode6243();
        System.out.println(leetcode6243.minimumFuelCost(new int[][]{{0,1},{0,2},{0,3}}, 5));
    }
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        int[] count = new int[n];
        int[] cost = new int[n];
        Arrays.fill(cost, - 1);
        List<List<Integer>> roadList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            roadList.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            count[road[0]] ++;
            count[road[1]] ++;
            roadList.get(road[0]).add(road[1]);
            roadList.get(road[1]).add(road[0]);
        }
        Deque<Integer> start = new ArrayDeque<>();
        start.offer(0);
        int baseCost = 0;
        while (start.size() != 0) {
            int size = start.size();
            for (int i = 0; i < size; i++) {
                int current = start.poll();
                cost[current] = baseCost;
                List<Integer> currentList = roadList.get(current);
                for (int z : currentList) {
                    if (cost[z] == -1) {
                        start.offer(z);
                    }
                }
            }
            baseCost++;
        }
        long result = 0;
        int temp = seats;
        while (check(count)) {
            List<Integer> currentList = new ArrayList<>();
            for (int i = 0; i < count.length; i++) {
                if (count[i] == 1) {
                    currentList.add(i);
                    count[i] = 0;
                }
            }
            for (int i : currentList) {
                for (int j : roadList.get(i)) {
                    if (count[j] != 0) {
                        count[j]--;
                    }
                }
            }
            temp --;
            for (int i : currentList) {
                result += seats - 1 + cost[i];
            }
            if (temp == 0) {
                temp = seats;
            }
        }
        return result;
    }
    public boolean check(int[] count) {
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return true;
            }
        }
        return false;
    }

}
