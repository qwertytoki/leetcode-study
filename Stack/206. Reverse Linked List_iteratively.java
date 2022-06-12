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
    //https://www.youtube.com/watch?v=jY-EUKXYT20 
    // この解説がすごいわかりやすかった
    
    public ListNode reverseList(ListNode head) {
        ListNode previous= null;
        while(head != null){
            ListNode next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }
        return previous;
    }
}