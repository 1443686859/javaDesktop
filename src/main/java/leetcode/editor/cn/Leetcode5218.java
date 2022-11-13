package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode5218 {
    public static void main(String[] args) {
        Leetcode5218 leetcode5218 = new Leetcode5218();
        System.out.println(leetcode5218.minimumNumbers(3, 3));
    }
    Map<Integer, Integer> countMap;
    public int minimumNumbers(int num, int k) {
        countMap = new HashMap<>();
        if (num == 0) {
            return 0;
        }
        if (num < k || k == 0) {
            return -1;
        }
        dfs(num, k);
        return countMap.get(num);
    }
    public int dfs(int num, int k) {
        if (countMap.containsKey(num)) {
            return countMap.get(num);
        }
        if (num % 10 == k || num == k) {
            countMap.put(num, 1);
            return 1;
        }
        List<Integer> startList = new ArrayList<>();
        int max = num / 10;
        for (int i = 0 ; i <= max; i++) {
            if (i * 10 + k <= num)
                startList.add(i * 10 + k);
        }
        if (startList.size() == 0) {
            return -1;
        }
        int result = Integer.MAX_VALUE;
        for (int i = startList.size() - 1; i >= 0; i--) {
            int nextResult = dfs(num - startList.get(i), k);
            if (nextResult == -1 || nextResult == Integer.MAX_VALUE) {
                continue;
            }
            result = Math.min(result, 1 + nextResult);
        }
        if (result == Integer.MAX_VALUE) {
            countMap.put(num, -1);
        } else {
            countMap.put(num, result);
        }
        return result;
    }
}
