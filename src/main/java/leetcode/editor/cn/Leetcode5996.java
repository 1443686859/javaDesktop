package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode5996 {
    public static void main(String[] args) {
        Leetcode5996 leetcode5996 = new Leetcode5996();
        System.out.println(leetcode5996.countPairs(new int[]{10,2,3,4,9,6,3,10,3,6,3,9,1}, 4));
    }
    public int countPairs(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, List<Integer>> countMap = new HashMap<>();
        int result = 0;
        for (int i = 0; i < n; i++) {
            List<Integer> resultList = countMap.getOrDefault(nums[i], new ArrayList<>());
            resultList.add(i);
            countMap.put(nums[i], resultList);
        }
        for (Map.Entry<Integer, List<Integer>> key : countMap.entrySet()) {
            List<Integer> currentList = key.getValue();
            int count = 0;
            int size = currentList.size();
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    if (currentList.get(i) * currentList.get(j) % k == 0) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
    public  int factorial(int number) {
        if (number <= 1)
            return 1;
        else
            return number * factorial(number - 1);
    }
}
