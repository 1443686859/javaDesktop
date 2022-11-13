package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Leetcode6090 {
    public int minMaxGame(int[] nums) {
        List<Integer> startList = new ArrayList<>();
        for (int i : nums) {
            startList.add(i);
        }
        while (startList.size() != 1) {
            List<Integer> tempList = new ArrayList<>();
            int n = startList.size() / 2;
            for (int i = 0; i < n; i++) {
                if ((i & 1) == 0) {
                    tempList.add(Math.min(startList.get(2 * i), startList.get(2 * i + 1)));
                } else {
                    tempList.add(Math.max(startList.get(2 * i), startList.get(2 * i + 1)));
                }
            }
            startList = tempList;
        }
        return startList.get(0);
    }
}
