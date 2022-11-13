package leetcode.editor.cn;

public class Leetcode5954 {
    public static void main(String[] args) {
        Leetcode5954 solution = new Leetcode5954();
        System.out.println(solution.minimumRefill(new int[]{1,2,4,4,5}, 6, 5));
    }
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int alice = capacityA;
        int bob = capacityB;
        int left = 0;
        int right = plants.length - 1;
        int result = 0;
        while (left <= right) {
            if (left == right) {
                int last = alice > bob ? alice : bob;
                if (last < plants[left]) {
                    result++;
                }
                left--;
                break;
            }
            if (alice >= plants[left]) {
                alice -= plants[left];
            } else {
                result++;
                alice = capacityA - plants[left];
            }
            left ++;
            if (bob >= plants[right]) {
                bob -= plants[right];
            } else {
               bob = capacityB - plants[right];
               result++;
            }
            right--;
        }
        return result;
    }
}
