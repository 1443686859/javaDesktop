使用 中序遍历获得有序队列 再根据 二分查找得到答案
中序遍历 迭代版本：
###
        TreeNode current = root;
        while (current != null || !deque.isEmpty()) {
            while (current != null) {
                deque.addLast(current);
                current = current.left;
            }
            current = deque.pollLast();
            list.add(current.val);
            current = current.right;
        }
将所有左子树都存进栈中
