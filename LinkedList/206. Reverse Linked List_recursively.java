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
    
    // https://leetcode.com/problems/reverse-linked-list/discuss/58125/In-place-iterative-and-recursive-Java-solution
    // recursively はSuggestionの一番高評価のやつ
    
    public ListNode reverseList(ListNode head){
        return reverseListInt(head,null);
    }
    
    private ListNode reverseListInt(ListNode head, ListNode previous){
        if(head == null){
            return previous;
        }
        ListNode next = head.next;
        head.next = previous;
        return reverseListInt(next,head);
    }
}

