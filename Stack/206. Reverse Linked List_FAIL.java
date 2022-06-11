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
    public ListNode reverseList(ListNode head) {
        // use Stack and reverse it.
        
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while(node != null){
            stack.push(node);
            node = node.next;
        }
        ListNode answer = new ListNode(0);
        ListNode pointer = answer;
        while(!stack.isEmpty()){
            pointer.next = stack.pop();
            pointer = pointer.next;
        }
        return answer.next;
    }
}