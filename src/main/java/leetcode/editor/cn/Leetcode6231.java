package leetcode.editor.cn;

import java.util.PriorityQueue;

public class Leetcode6231 {
    public static void main(String[] args) {
        Leetcode6231 leetcode6231 = new Leetcode6231();
        System.out.println(leetcode6231.totalCost(new int[]{1,2,4,1}, 3,3));
    }
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        PriorityQueue<Integer> queue1 = new PriorityQueue<>();
        // 判断重合
        int end1 = candidates;
        int start = costs.length - candidates;
        if (end1 > start) {
            start = candidates;
        }
        for (int i = 0; i < end1; i ++) {
            queue.add(costs[i]);
        }
        int index = end1;
        for (int i = start; i < costs.length; i++) {
            queue1.add(costs[i]);
        }
        int index1 = start - 1;
        long result = 0;
        for (int i = 0; i < k; i ++) {

            int current = queue.isEmpty() ? Integer.MAX_VALUE :  queue.peek();
            int current1 = queue1.isEmpty() ? Integer.MAX_VALUE : queue1.peek();
            if (current <= current1) {
                result += current;
                queue.poll();
                if (index < costs.length && index <= index1) {
                    queue.add(costs[index]);
                    index++;
                }
            } else {
                result += current1;
                queue1.poll();
                if (index1 >= 0 && index1 >= index) {
                    queue1.add(costs[index1]);
                    index1--;
                }
            }
        }
        return result;
    }
}
