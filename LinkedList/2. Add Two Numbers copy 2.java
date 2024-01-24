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
        ListNode current = sentinel;
        int additional = 0;
        
        while(l1 != null || l2 != null || additional != 0){
            int l1val = l1 == null?0:l1.val;
            int l2val = l2 == null?0:l2.val;
            int sum = l1val + l2val + additional;
            current.next = new ListNode(sum % 10);
            additional = sum / 10;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
            current = current.next;
            
        }

        return sentinel.next;
            
    }
}