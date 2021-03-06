// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// LRU Cache
// https://leetcode.com/problems/lru-cache/
// 

class LRUCache {
    private class Node {
        public Node prev;
        public Node next;
        public int key;
        public int value;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    private int cap;
    private HashMap<Integer, Node> map;
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node current = map.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        moveToTail(current);
        return current.value;
    }
    
    public void put(int key, int value) {
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }
        if (map.size() == cap) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        moveToTail(newNode);
        
    }
    public void moveToTail(Node current) {
        tail.prev.next = current;
        current.prev = tail.prev;
        current.next = tail;
        tail.prev = current;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

