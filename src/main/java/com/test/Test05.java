package com.test;

import java.util.HashSet;
import java.util.Scanner;

class Union{
    int[] parent;
    public Union(int n ){
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        if (parentX == parentY) {
            return;
        }
        parent[parentX] = parent[parentY];
    }
}
public class Test05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String start = in.nextLine();
        String[] starts = start.split(" ");
        int n = starts.length;
        Union union = new Union(n);
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            grid[0][i] = Integer.parseInt(starts[i]);
        }
        for (int i = 1; i < n; i++) {
            String current = in.nextLine();
            String[] currents = current.split(" ");
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(currents[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && grid[i][j] == 1) {
                    union.union(i, j);
                }
            }
        }
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            count[union.find(i)]++;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] != 0) {
                result++;
            }
        }
        System.out.println(result);
    }


}
