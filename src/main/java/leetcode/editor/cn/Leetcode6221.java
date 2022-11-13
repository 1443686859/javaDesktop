package leetcode.editor.cn;

import java.util.*;

public class Leetcode6221 {
    public static void main(String[] args) {
        Leetcode6221 leetcode6221 = new Leetcode6221();
        System.out.println(leetcode6221.mostPopularCreator(new String[]{"a","b"}, new String[]{
                "a","b"}, new int[]{0,0}));
    }
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, long[]> countMap = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        long max = -1;
        for (int i = 0; i < creators.length; i++) {
            long[] current = countMap.get(creators[i]);
            if (current == null) {
                current = new long[2];
                current[0] += views[i];
                current[1] = i;
            } else {
                current[0] += views[i];
                if (views[i] > views[(int)current[1]]) {
                    current[1] = i;
                } else if (views[i] == views[(int)current[1]]) {
                    current[1] = ids[i].compareTo(ids[(int)current[1]]) < 0 ? i : current[1];
                }
            }
            countMap.put(creators[i], current);
            if (current[0] > max) {
                max = current[0];
                result.clear();
                result.add(Arrays.asList(creators[i], ids[(int)current[1]]));
            } else if (current[0] == max) {
                result.add(Arrays.asList(creators[i], ids[(int)current[1]]));
            }
        }
        return result;
    }
}
