package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode6001 {
    public long smallestNumber(long num) {
        List<Integer> currentList = new ArrayList<>();
        if (num == 0) {
            return 0;
        }
        boolean isPositive = num > 0 ? true : false;
        if (!isPositive) {
            num = 0 - num;
        }
        while (num != 0) {
            currentList.add((int)(num % 10));
            num /= 10;
        }
        Collections.sort(currentList, (a, b) -> {
            if (isPositive) {
                return a -b;
            } else {
                return b - a;
            }
        });
        long result = 0;
        int index = 0;
        while (currentList.get(index) == 0) {
            index++;
        }
        result = currentList.get(index);
        currentList.remove(index);
        for (int i : currentList) {
            result = result * 10 + i;
        }
        return isPositive ? result : 0 - result;
    }
}
