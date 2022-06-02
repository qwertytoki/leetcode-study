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
        // check next, if next value is same value as current, delete this value and next value
        // but then if duplication continues 3 or more, it will have ptoblem.
        // so when it detects duplication, check until finish the duplication.
        // when duplication is ended, start deleting.   
        if(head.next == null) return head;
        ListNode node = head;
        while(node != null&& node.next!= null){
            ListNode current = node;
            ListNode next = node.next;
            while(current.val == next.val){
                next = next.next;
                if(next == null){
                    break;
                }
            }
            node = next;
        }
        return node;
    }
}