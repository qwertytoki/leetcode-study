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

// Setを使った別解  こっちのほうがシンプル
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodeSeen = new HashSet<>();
        while(head != null){
            if(nodeSeen.contains(head)){
                return true;
            }
            nodeSeen.add(head);
            head = head.next;
        }
        return false;
    }
}