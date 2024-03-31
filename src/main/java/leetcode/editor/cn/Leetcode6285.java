package leetcode.editor.cn;

import java.util.PriorityQueue;

public class Leetcode6285 {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> {return b - a;});
        for (int i : nums) {
            priorityQueue.add(i);
        }
        long result = 0;
        for (int i = 0; i < k; i++) {
            int current = priorityQueue.poll();
            result += 1l * current;
            priorityQueue.add((current + 2) /3);
        }
        return result;
    }
}
