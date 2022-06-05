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
        // create number from linked list
        // calculate it
        // make linked list again 
        // return?
        int sum = generateNumber(l1) + generateNumber(l2);
        
        
        return l1;
    }
    
    private int generateNumber(ListNode node){
        int count = 0;
        int number = 0;
        while(node != null){
            number += Math.pow(10,count) * node.val;
            count++;
            node = node.next;
        }
        return number; 
    }
}