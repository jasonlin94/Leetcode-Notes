// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Copy List with Random Pointer
// https://leetcode.com/problems/copy-list-with-random-pointer/
// 

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = dummy;
        RandomListNode newNode;
        while (head != null) {
            if (map.containsKey(head)) {
                newNode = map.get(head); // maybe added by random pointer
            } else {
                newNode = new RandomListNode(head.label);
                map.put(head, newNode);
            }
            pre.next = newNode;
            // random
            // 没判断random是否为null
            if (head.random != null) {
                if (map.containsKey(head.random)) {
                    newNode.random = map.get(head.random);
                } else {
                    map.put(head.random, new RandomListNode(head.random.label));
                    newNode.random = map.get(head.random);
                }
            }
            head = head.next;
            pre = pre.next;
        }
        return dummy.next;
    }
}

