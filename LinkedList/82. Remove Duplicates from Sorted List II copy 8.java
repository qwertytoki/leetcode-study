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
        ListNode stayFirst = new ListNode(0, head);
        ListNode current = stayFirst;
        while(head != null){
            if(head.next != null && head.val == head.next.val){
                while(head.next != null && head.val == head.next.val){
                    head = head.next;
                }
                current.next = head.next;
            }else{
                current = current.next;
            }
            head = head.next;
        }
        return stayFirst.next;
    }
}

// speed:O(N)
// space:O(1)