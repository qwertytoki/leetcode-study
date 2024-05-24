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
        int overVal = 0;
        ListNode node = new ListNode();
        ListNode sentinel = node;
        while(l1 != null || l2 != null || overVal != 0){
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            int currentVal = l1Val + l2Val + overVal;
            overVal = currentVal/10;
            currentVal = currentVal%10;
            node.next = new ListNode(currentVal);
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            node = node.next;
        }
        return sentinel.next;
    }
}