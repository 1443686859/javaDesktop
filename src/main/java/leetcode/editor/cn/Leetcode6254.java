package leetcode.editor.cn;

import java.util.Arrays;

public class Leetcode6254 {
    public long dividePlayers(int[] skill) {
        long result = 0;
        Arrays.sort(skill);
        int n = skill.length;
        int max = n / 2;
        int base = skill[0] + skill[n - 1];
        for (int i = 0; i < max; i++) {
            if (skill[i] + skill[n - 1- i] != base) {
                return - 1;
            }
            result += 1l * skill[i] * skill[n - 1- i];
        }
        return result;
    }
}
