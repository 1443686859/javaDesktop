package leetcode.editor.cn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Leetcode6016 {
    public List<String> cellsInRange(String s) {
        List<String> result = new ArrayList<>();
        String[] ss = s.split(":");
        int lStart = ss[0].charAt(0) - 'A';
        int lEnd = ss[1].charAt(0) - 'A';
        int rStart = ss[0].charAt(1) - '0';
        int rEnd = ss[1].charAt(1) - '0';
        for (int i = lStart; i <= lEnd; i++) {
            for (int j = rStart; j <= rEnd; j++) {
                String current = (char)('A' + i) + "" + j;
                result.add(current);
            }
        }
        return result;
    }
}
