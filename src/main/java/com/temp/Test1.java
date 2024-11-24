package com.temp;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class Test1 {
    /**
      1
     /\
     2 3
     /
     **/
   static class TreeNode {
        int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int value) {
           val = value;
       }
        TreeNode(int value, TreeNode leftNode, TreeNode rightNode) {
           left = leftNode;
           right = rightNode;
           val = value;
       }
    }

    public static void main(String[] args) {

        TreeNode left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        TreeNode right = new TreeNode(3, new TreeNode(6), new TreeNode(7));
        TreeNode root = new TreeNode(1, left, right);
        TreeNode temp = buildTree(new int[] {1,2,3,4,5,6,7});
        bfs(temp);
    }
    public static void bfs(TreeNode root) {
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = deque.poll();
                System.out.println(current.val);
                if (current.left != null) {
                    deque.addLast(current.left);
                }
                if (current.right != null) {
                    deque.addLast(current.right);
                }
            }
        }
    }
    public static TreeNode buildTree(int[] array) {
       if (array.length == 0) {
           return null;
       }
       TreeNode root = new TreeNode(array[0]);
       ArrayDeque<TreeNode> deque = new ArrayDeque<>();
       deque.add(root);
       int index = 1;
       while (!deque.isEmpty()) {
           int size = deque.size();
           for (int i = 0; i < size; i++) {
               TreeNode current = deque.poll();
               if (index + 2 > array.length) {
                   break;
               }
               current.left = new TreeNode(array[index++]);
               current.right = new TreeNode(array[index++]);
               deque.addLast(current.left);
               deque.addLast(current.right);
           }
       }
       return root;
    }
}
