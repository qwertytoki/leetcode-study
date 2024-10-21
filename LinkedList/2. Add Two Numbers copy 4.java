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
        ListNode result = new ListNode();
        ListNode currentNode = result;
        int remain = 0;

        while(l1 != null || l2 != null || remain != 0){
            int l1Val = l1==null ? 0 : l1.val;
            int l2Val = l2==null ? 0 : l2.val;
            
            int current = l1Val + l2Val + remain;
            remain = current / 10;
            current = current % 10;
            currentNode.next = new ListNode(current);
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
            currentNode = currentNode.next;
        }
        return result.next;
    }
}