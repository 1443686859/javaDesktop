package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Leetcode6296 {
    public int alternateDigitSum(int n) {
        StringBuilder result = new StringBuilder();
        while (n != 0) {
            result.insert(0, n % 10);
            n /= 10;
        }
        int ans = 0;
        int p = 1;
        for (int i = 0; i < result.length(); i++) {
            ans += p * (result.charAt(i) - '0');
            p = -p;
        }
        return ans;
    }
}
