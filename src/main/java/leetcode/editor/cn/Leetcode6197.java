package leetcode.editor.cn;

public class Leetcode6197 {
}
class LUPrefix {
    int[] array;
    int length;
    public LUPrefix(int n) {
        array = new int[n + 1];
        length = 0;
    }

    public void upload(int video) {
        array[video] = video;
        int index = length + 1;
        while (index <array.length && array[index] != 0) {
            index++;
        }
        length = index - 1;
    }

    public int longest() {
        return length;
    }
}
