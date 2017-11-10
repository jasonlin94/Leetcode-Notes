// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Add Two Numbers
// https://leetcode.com/problems/add-two-numbers/
// 

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        dummy.next = l1;
        int inc = 0;
        int sum = l1.val + l2.val;
        if (sum >= 10) {
            sum = sum - 10;
            inc = 1;
        }
        l1.val = sum;
        while (l1.next != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
            l1.val += inc;
            inc = 0;
            sum = l1.val + l2.val;
            if (sum >= 10) {
                sum = sum - 10;
                inc = 1;
            }
            l1.val = sum;
        }
        if (l2.next != null) {
            l1.next = l2.next;
            // l2.next = null;
        }
        while (l1.next != null && inc == 1) {
            l1 = l1.next;
            l1.val += inc;
            inc = 0;
            if (l1.val >= 10) {
                l1.val = l1.val - 10;
                inc = 1;
            }
        }
        // [5], [5] -> [0, 1]
        if (l1.next == null && inc == 1) {
            l1.next = new ListNode(1);
        }
        return dummy.next;
    }
}

