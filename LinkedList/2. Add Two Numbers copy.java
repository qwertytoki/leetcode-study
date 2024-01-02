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
        ListNode sentinel = new ListNode();
        ListNode node = sentinel;
        
        int over = 0;
        while(l1 != null || l2 != null || over != 0){
            int l1Val = l1==null? 0 : l1.val;
            int l2Val = l2==null? 0 : l2.val;
            int current = l1Val + l2Val + over;
            over = current / 10;
            current = current % 10;
            node.next = new ListNode(current);
            node = node.next;
            
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        return sentinel.next;
    }
}