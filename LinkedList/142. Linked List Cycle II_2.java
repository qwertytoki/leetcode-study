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
        Set<ListNode> alreadySeenSet = new HashSet<>();
        while(head != null){
            if(alreadySeenSet.contains(head)){
                return head;
            }
            alreadySeenSet.add(head);
            head = head.next;
        }
        return null;
    }
}