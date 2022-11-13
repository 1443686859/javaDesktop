package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
    public static void main(String[] args) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        int sum = 0;
        for (int i = 1; i <= 14; i++) {
            sum += i;
            if (sum >= 14 && resultMap.containsKey(sum - 14)) {
                System.out.println(i);
                break;
            }
            resultMap.put(sum, 1);
        }
    }
}
