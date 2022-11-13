package leetcode.editor.cn;

import java.util.*;
 class NumberContainers {

    Map<Integer, Integer> indexMap;
    Map<Integer, TreeSet<Integer>> valueMap;
    public NumberContainers() {
        indexMap = new HashMap<>();
        valueMap = new HashMap<>();
    }

    public void change(int index, int number) {
            int old = indexMap.getOrDefault(index, - 1);
            if (old != -1) {
                TreeSet<Integer> oldSet = valueMap.getOrDefault(old, new TreeSet<>());
                oldSet.remove(index);
                valueMap.put(old, oldSet);
            }
            TreeSet<Integer> current = valueMap.getOrDefault(number, new TreeSet<>());
            current.add(index);
            valueMap.put(number, current);
            indexMap.put(index, number);

    }

    public int find(int number) {
        TreeSet<Integer> current = valueMap.getOrDefault(number, new TreeSet<>());
        return current.isEmpty() ? -1 : current.first();
    }
}
