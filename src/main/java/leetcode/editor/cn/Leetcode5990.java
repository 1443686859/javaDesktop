package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Leetcode5990 {
    public static void main(String[] args) {
        Leetcode5990 solution = new Leetcode5990();
        System.out.println(solution.findLonely(new int[]{0}));
    }
    public List<Integer> findLonely(int[] nums) {
        List<Integer> resultList = new ArrayList<>();
        int[] result = new int[1000001];
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            result[nums[i]] ++;
            max = Math.max(nums[i], max);
        }
        if (result[0] == 1 && result[1] == 0) {
            resultList.add(0);
        }
        if (result[max] == 1 && max != 0 && result[max - 1] == 0) {
            resultList.add(max);
        }
        for (int i = 1; i < max; i++) {
            if (result[i] == 1 && (i > 0 && result[i - 1] == 0) && (i <= max - 1 && result[i + 1] == 0)) {
                resultList.add(i);
            }
        }
        return resultList;
    }
}
