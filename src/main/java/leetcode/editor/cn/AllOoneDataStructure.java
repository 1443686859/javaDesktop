//请你设计一个用于存储字符串计数的数据结构，并能够返回计数最小和最大的字符串。 
//
// 实现 AllOne 类： 
//
// 
// AllOne() 初始化数据结构的对象。 
// inc(String key) 字符串 key 的计数增加 1 。如果数据结构中尚不存在 key ，那么插入计数为 1 的 key 。 
// dec(String key) 字符串 key 的计数减少 1 。如果 key 的计数在减少后为 0 ，那么需要将这个 key 从数据结构中删除。测试用例
//保证：在减少计数前，key 存在于数据结构中。 
// getMaxKey() 返回任意一个计数最大的字符串。如果没有元素存在，返回一个空字符串 "" 。 
// getMinKey() 返回任意一个计数最小的字符串。如果没有元素存在，返回一个空字符串 "" 。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["AllOne", "inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", 
//"getMinKey"]
//[[], ["hello"], ["hello"], [], [], ["leet"], [], []]
//输出
//[null, null, null, "hello", "hello", null, "hello", "leet"]
//
//解释
//AllOne allOne = new AllOne();
//allOne.inc("hello");
//allOne.inc("hello");
//allOne.getMaxKey(); // 返回 "hello"
//allOne.getMinKey(); // 返回 "hello"
//allOne.inc("leet");
//allOne.getMaxKey(); // 返回 "hello"
//allOne.getMinKey(); // 返回 "leet"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= key.length <= 10 
// key 由小写英文字母组成 
// 测试用例保证：在每次调用 dec 时，数据结构中总存在 key 
// 最多调用 inc、dec、getMaxKey 和 getMinKey 方法 5 * 10⁴ 次 
// 
// Related Topics 设计 哈希表 链表 双向链表 👍 231 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author  YourName
 * @date 2022-03-16 20:45:20
 */
public class AllOoneDataStructure{
    public static void main(String[] args) {
//        Solution solution = new AllOoneDataStructure().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class AllOne {
    Node root;
    Map<String, Node> nodes;
    public AllOne() {
        root = new Node();
        root.prev = root;
        root.next = root; // 初始化链表哨兵，下面判断节点的 next 若为 root，则表示 next 为空（prev 同理）
        nodes = new HashMap<>();
    }
    
    public void inc(String key) {
        if (nodes.containsKey(key)) {
            Node cur = nodes.get(key);
            Node next = cur.next;
            if (next == root || next.currentCount > cur.currentCount + 1) {
                nodes.put(key, cur.insert(new Node(key, cur.currentCount + 1)));
            } else {
                next.currentStrings.add(key);
                nodes.put(key, next);
            }
            cur.currentStrings.remove(key);
            if (cur.currentStrings.isEmpty()) {
                cur.remove();
            }
        } else {
            if (root.next == root || root.next.currentCount > 1) {
                nodes.put(key, root.insert(new Node(key, 1)));
            } else {
                root.next.currentStrings.add(key);
                nodes.put(key, root.next);
            }
        }
    }
    
    public void dec(String key) {
        Node cur = nodes.get(key);
        if (cur.currentCount == 1) {
            nodes.remove(key);
        } else {
            Node prev = cur.prev;
            if (prev == root || prev.currentCount < cur.currentCount - 1) {
               nodes.put(key, prev.insert(new Node(key, cur.currentCount - 1)));
            } else {
                prev.currentStrings.add(key);
                nodes.put(key, prev);
            }
        }
        cur.currentStrings.remove(key);
        if (cur.currentStrings.isEmpty()) {
            cur.remove();
        }
    }
    
    public String getMaxKey() {
        return root.prev != root ? root.prev.currentStrings.iterator().next() : "";
    }
    
    public String getMinKey() {
        return root.next != root ? root.next.currentStrings.iterator().next() : "";
    }
}
class Node {
        Node prev;
        Node next;
        Set<String> currentStrings;
        int currentCount;

        public Node() {
            this("", 0);
        }
        public Node(String current, int count) {
            this.currentCount = count;
            this.currentStrings = new HashSet<>();
            this.currentStrings.add(current);
        }
        public Node insert(Node node) {
            node.prev = this;
            node.next = this.next;
            node.prev.next = node;
            node.next.prev = node;
            return node;
        }
        public void remove() {
            this.prev.next = this.next;
            this.next.prev = this.prev;
        }
}
/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
//leetcode submit region end(Prohibit modification and deletion)

}