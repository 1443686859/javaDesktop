package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Leetcode6288 {
    class DataStream {
        int count;
        int size;
        int target;
        public DataStream(int value, int k) {
            count = 0;
            size = k;
            target = value;
        }

        public boolean consec(int num) {
            if (num == target) {
                count++;
            } else {
                count = 0;
            }
            if (count >= size) {
                return true;
            }
            return false;
        }
    }
}
