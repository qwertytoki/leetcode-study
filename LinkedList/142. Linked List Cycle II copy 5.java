/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode collapse = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                collapse = slow;
                break;
            }
        }
        while(collapse != null){
            if(head == collapse){
                return head;
            }
            head = head.next;
            collapse = collapse.next;
        }
        return collapse;
    }
}