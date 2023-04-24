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
        //fastとslowが交わる位置から、posまでの位置と、startからposまでの位置が一致する
        ListNode fast = head;
        ListNode slow = head;
        ListNode collapse = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                collapse = fast;
                break;
            }
        }
        while(collapse!= null){
            if(collapse == head){
                return head;
            }
            collapse = collapse.next;
            head = head.next;
        }
        return collapse;
    }
}