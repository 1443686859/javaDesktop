package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Leetcode2055 {
    public static void main(String[] args) {
        Leetcode2055 leetcode2055 = new Leetcode2055();
        System.out.println(leetcode2055.platesBetweenCandles("||*",
                new int[][]{{2,2}}));
    }
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        List<Integer> currentList = new ArrayList<>();
        int end = s.length();
        for (int i = 0; i < end; i++) {
            if (s.charAt(i) == '|') {
                currentList.add(i);
            }
        }
        int i = 0;
        for (int[] current : queries) {
            int l = 0;
            int r = currentList.size() - 1;
            int start = -1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (currentList.get(mid) >= current[0]) {
                    r = mid - 1;
                } else if (currentList.get(mid) < current[0]) {
                    l = mid + 1;
                }
            }
            start = l;
            r = currentList.size() - 1;
            l = 0;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (currentList.get(mid) <= current[1]) {
                    l = mid + 1;
                } else if (currentList.get(mid) > current[1]) {
                    r = mid - 1;
                }
            }
            int currentEnd = r;
            if (currentEnd < start) {
                ans[i++] = 0;
            } else {
                ans[i++] = currentList.get(currentEnd) - currentList.get(start) - 1 -(currentEnd - start -1);
            }
        }
        return ans;

    }

}
