class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head != null){
            ListNode nextTemp = head.next;
            head.next = prev;
            prev = head;
            head = nextTemp; 
        }
        return prev;
    }
}

// Time : O(N)
// Space: O(1)