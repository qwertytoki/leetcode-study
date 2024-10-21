/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(0);
        ListNode result = sentinel;
        int overflow = 0;
        while(l1 != null || l2 != null || overflow != 0 ){
            int l1Val = (l1 != null)? l1.val : 0;
            int l2Val = (l2 != null)? l2.val : 0;
            int current = l1Val + l2Val + overflow;
            overflow = current / 10;
            result.next = new ListNode(current %10);
            l1 = (l1 != null)? l1.next:null;
            l2 = (l2 != null)? l2.next:null;
            result = result.next;
        }
        return sentinel.next;
    }
}

// time : O(max(M,N)) M:l1.length N: l2.length
// space: O(1) -> we don't count the answer as space. 