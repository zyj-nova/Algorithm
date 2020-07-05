class MaxQueue {
    class Node {
        int val;
        Node prev, next;

        public Node(int v) {
            this.val = v;
            this.prev = null;
            this.next = null;
        }
    }

    class MyLinkedList {
        Node head, tail;

        public MyLinkedList() {
            head = new Node(0);
            tail = new Node(0);
            head.next = tail;
            tail.prev = head;
        }

        public void offerLast(Node n) {
            // 队尾插入元素
            n.prev = tail.prev;
            n.prev.next = n;
            n.next = tail;
            tail.prev = n;
        }

        public Node pollFirst() {
            // 队首移除元素
            Node res = head.next;
            head.next = head.next.next;
            head.next.prev = head;
            return res;
        }

        public Node pollLast() {
            // 队尾移除元素
            Node res = tail.prev;
            tail.prev = tail.prev.prev;
            tail.prev.next = tail;
            return res;
        }

        // 查看队首元素
        public Node peek() {
            return head.next;
        }

        // 查看队尾元素
        public Node back() {
            return tail.prev;
        }

        public boolean isEmpty() {
            return head.next == tail;
        }
    }

    private MyLinkedList queue;
    private MyLinkedList dequeue;// 维护最大值

    public MaxQueue() {
        queue = new MyLinkedList();
        dequeue = new MyLinkedList();
    }

    public int max_value() {
        return queue.isEmpty() ? -1 : dequeue.peek().val;
    }

    public void push_back(int value) {
        queue.offerLast(new Node(value));
        /**
         * 在插入每一个元素 value 时，从队列尾部依次取出比当前元素 value 小的元素， 直到遇到一个比当前元素大的元素 value' 即可。
         */
        while (!dequeue.isEmpty()) {
            if (dequeue.back().val < value) {
                dequeue.pollLast();
            } else {
                break;
            }
        }
        dequeue.offerLast(new Node(value));
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int res = queue.pollFirst().val;
        if (dequeue.peek().val == res) {
            dequeue.pollFirst();
        }
        return res;
    }

}