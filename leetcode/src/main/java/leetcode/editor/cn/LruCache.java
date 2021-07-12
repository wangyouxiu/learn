//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 105 
// 最多调用 2 * 105 次 get 和 put 
// 
// Related Topics 设计 哈希表 链表 双向链表 
// 👍 1490 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache {
    public static void main(String[] args) {
        LRUCache solution = new LruCache().new LRUCache(1);
        solution.put(2, 1);
        solution.get(2);
        solution.put(3, 2);
        solution.get(2);
        solution.get(3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 使用链表+hashMap实现
     */
    class LRUCache {

        private Node first;
        private Node end;
        private Map<Integer, Node> cacheMap;
        private int capacity;

        public LRUCache(int capacity) {
            cacheMap = new HashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            Node node = cacheMap.get(key);
            if (node != null) {
                //将node移动至链表尾部
                moveToEnd(node);
                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            Node node = cacheMap.get(key);
            if (node != null) {
                node.value = value;
                cacheMap.put(key, node);
                //将node移动至链表尾部
                moveToEnd(node);
            } else {
                if (cacheMap.size() >= capacity) {
                    //删除头部元素
                    Node node1 = removeFirst();
                    if (node1 != null) {
                        cacheMap.remove(node1.key);
                    }
                }
                Node node1 = new Node(key, value);
                cacheMap.put(key, node1);
                //将节点加入链表
                addToList(node1);
            }

        }

        public void moveToEnd(Node node) {
            if (node == end) {
                return;
            } else if (node == first) {
                first = node.next;
                first.pre = null;
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            end.next = node;
            node.pre = end;
            end = node;
        }

        public Node removeFirst() {
            if (first == null) {
                return null;
            }
            Node temp = first;
            first = first.next;
            return temp;
        }

        public void addToList(Node node) {
            if (first == null) {
                first = node;
                end = node;
            } else {
                end.next = node;
                node.pre = end;
                end = node;
            }
        }

        //定义一个Node
        class Node {
            private Node pre;
            private Node next;
            private int key;
            private int value;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

    }


    /**
     * 继承LinkedHashMap实现LRU
     */
//    class LRUCache extends LinkedHashMap<Integer, Integer> {
//
//        private final int capacity;
//
//        public LRUCache(int capacity) {
//            super(capacity, 0.75f, true);
//            this.capacity = capacity;
//        }
//
//        @Override
//        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//            return size() > capacity;
//        }
//
//        public int get(int key) {
//            return getOrDefault(key, -1);
//        }
//
//        public void put(int key, int value) {
//            super.put(key, value);
//        }
//
//
//    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}