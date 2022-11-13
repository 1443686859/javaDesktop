package leetcode.editor.cn;


import java.util.Arrays;

public class Leetcode6111 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] result = new int[m][n];
        ListNode current = head;
        for (int i = 0; i < m; i++) {
            Arrays.fill(result[i], -1);
        }
        int col = 0;
        int row = 0;
        int start = 0;
        while (current != null) {
            int currentVal = current.val;
            if (start == 0) {
                result[row][col++] = currentVal;
                if (col == n || result[row][col] != -1) {
                    start = 1;
                    col--;
                    if (row + 1 < m) {
                        row++;
                    }
                }
            } else if (start == 1) {
                result[row++][col] = currentVal;
                if (row == m || result[row][col] != -1) {
                    start = 2;
                    row--;
                    if (col - 1 >= 0) {
                        col--;
                    }
                }
            } else if (start == 2) {
                result[row][col--] = currentVal;
                if (col == -1 || result[row][col] != -1) {
                    start = 3;
                    col++;
                    if (row - 1 >= 0) {
                        row--;
                    }
                }
            } else if (start == 3) {
                result[row--][col] = currentVal;
                if (row == -1 || result[row][col] != -1) {
                    start = 0;
                    row++;
                    if (col + 1 < n) {
                        col++;
                    }
                }
            }
            current = current.next;
        }
        return result;
    }
}
