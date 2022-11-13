package leetcode.editor.cn;

import java.util.ArrayList;

public class Leetcode6002 {
    public static void main(String[] args) {
          Bitset obj = new Bitset(5);
  obj.fix(3);
  obj.unfix(1);
  obj.flip();
  boolean param_4 = obj.all();
  boolean param_5 = obj.one();
  int param_6 = obj.count();
  String param_7 = obj.toString();
    }
    static class Bitset {
        int base = 64;
        int size;
        int oneSize;
        long[] currentArray;
        public Bitset(int size) {
            this.size = size;
            int count = (size - 1 + base) / base;
            currentArray = new long[count];
            for (int i = 0; i < count; i++) {
                currentArray[i] = 0l;
            }
            oneSize = 0;
        }

        public void fix(int idx) {
            int realIndex = size - 1 - idx;
            int currentIndex = (realIndex + 1 )/ base;
            int count = realIndex % base;
            long current = currentArray[currentIndex];
            long temp = (long)Math.pow(2, count - 1);
            if ((current & temp) == 0) {
                currentArray[currentIndex] += temp;
                oneSize ++;
            }
        }

        public void unfix(int idx) {
            int realIndex = size - 1 - idx;
            int currentIndex =  (realIndex + 1 )/ base;
            int count = realIndex % base;
            long current = currentArray[currentIndex];
            long temp = (long)Math.pow(2, count - 1);
            if ((current & temp) != 0) {
                currentArray[currentIndex] -= temp;
                oneSize--;
            }
        }

        public void flip() {
            for (int i = 0; i < currentArray.length; i++) {
                currentArray[i] = currentArray[i] & 0;
            }
        }

        public boolean all() {
            if (oneSize != size) {
                return false;
            }
            return true;
        }

        public boolean one() {
            if (oneSize > 0) {
                return false;
            }
            return true;
        }

        public int count() {
            return oneSize;
        }

        public String toString() {
            int last = size % base;
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < currentArray.length; i++) {
                int index = 0;
                long temp = currentArray[i];
                int max = base;
                if (i == currentArray.length - 1) {
                    max = last;
                }
                while (index < max) {
                    stringBuilder.append((temp & 1) == 1 ? 1:0);
                    temp >>= 1;
                    index ++;
                }
            }
            return stringBuilder.toString();
        }
    }
}
