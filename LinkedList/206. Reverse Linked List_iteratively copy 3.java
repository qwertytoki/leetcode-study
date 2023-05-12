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

// time:O(N)
// space:O(N)
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode reversed = new ListNode();
        ListNode node = reversed;

        LinkedList<ListNode> stack = new LinkedList<>();
        while(head != null){
            stack.add(head);
            head = head.next;
        }
        while(!stack.isEmpty()){
            node.next = new ListNode(stack.pollLast().val);
            node = node.next;
        }
        return reversed.next;
        
    }
}