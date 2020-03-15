class MyHashSet {
    class MyHashSet {
        private class Node {
            int val;
            Node next;

            public Node(int val) {
                this.val = val;
            }
        }

        private int size = 150;
        protected Node data[] = new Node[size];

        // 自定义哈希规则
        private int hash(int key) {
            return key % size;
        }

        /** Initialize your data structure here. */
        public MyHashSet() {

        }

        public void add(int key) {
            if (contains(key))
                return;
            int hashcode = hash(key);
            if (data[hashcode] == null) {// 这个hash值index位置没有元素，直接插入
                data[hashcode] = new Node(key);
                return;
            } else {// 链表头插法
                Node newEle = new Node(key);
                newEle.next = data[hashcode].next;
                data[hashcode].next = newEle;
            }
        }

        public void remove(int key) {
            if (!contains(key))
                return;
            int code = hash(key);
            Node cur = data[code];
            if (cur.val == key) {
                data[code] = data[code].next;
            } else {
                Node pre = data[code];
                while (cur != null) {
                    if (cur.val != key) {
                        pre = cur;
                        cur = cur.next;
                    } else {
                        break;
                    }
                }
                pre.next = cur.next;
            }
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            int code = hash(key);
            Node head = data[code];
            if (head == null) {
                return false;
            } else {
                while (head != null) {
                    if (head.val == key)
                        return true;
                    head = head.next;
                }
                return false;
            }
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such: MyHashSet obj
 * = new MyHashSet(); obj.add(key); obj.remove(key); boolean param_3 =
 * obj.contains(key);
 */
/**
 * 由于输入的key值在0-1000,000之间，直接申请100w的数组大小，哈希函数取 key%1000000 性能可以达到O(1) 但是空间开销比较大
 * private int hash(int key) { return key % 1000001; }
 * 
 * private int data[] = new int[1000000];
 * 
 * 
 * public MyHashSet() { for(int i = 0; i < data.length; i++){ data[i] = -1; } }
 * 
 * public void add(int key) { int code = hash(key); if (data[code] == key)
 * return; data[code] = key; }
 * 
 * public void remove(int key) { int code = hash(key); data[code] = -1; }
 * 
 * public boolean contains(int key) {
 * 
 * int code = hash(key); return data[code] != -1; }
 */