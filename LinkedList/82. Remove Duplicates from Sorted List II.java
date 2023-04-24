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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode(0, head);
        ListNode pred = sentinel;
        
        while(head != null){
            if(head.next != null && head.val == head.next.val){
                // remove this node. until next different value.
                while(head.next != null && head.val == head.next.val){
                    head = head.next;
                }
                // ignore all duplicates
                pred.next = head.next;
            }else{
                pred = pred.next;
            }
            // finally we can proceed head node.
            head = head.next;
        }
        return sentinel.next;
    }
}