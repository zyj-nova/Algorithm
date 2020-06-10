import java.util.HashMap;
import java.util.Map;

class Node {
    public int key, val;
    public Node prev, next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

// 双向链表
class DoubleList {
    private Node head, tail;
    private int length = 0;

    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(Node n) {
        // 双向链表头部添加节点
        n.next = head.next;
        n.prev = head;

        head.next.prev = n;
        head.next = n;
        length++;

    }

    public void remove(Node x) {
        // 删除链表中的结点
        x.prev.next = x.next;
        x.next.prev = x.prev;
        length--;

    }

    public Node removeLast() {
        // 首先判断链表是否为空
        if (head.next == tail) {
            return null;
        }
        Node res = tail.prev;
        remove(res);
        return res;
    }

    public int size() {
        return this.length;
    }

}

class LRUCache {

    private Map<Integer, Node> map;

    private DoubleList cache;

    private int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        cache = new DoubleList();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key).val;
        put(key, val);
        return val;

    }

    public void put(int key, int value) {

        Node x = new Node(key, value);
        if (map.containsKey(key)) {
            // map中存在key，更新值
            cache.remove(map.get(key));
        } else {
            if (this.capacity == cache.size()) {
                // 删除最久未使用的结点 -- 最后一个结点
                Node last = cache.removeLast();
                map.remove(last.key);
            }
        }
        cache.addFirst(x);
        map.put(key, x);// if else 中都有的逻辑，提取出来

    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // 返回 1
        cache.put(3, 3); // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2)); // 返回 -1 (未找到)
        cache.put(4, 4); // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1)); // 返回 -1 (未找到)
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

    }
}