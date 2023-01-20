class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while(current != null){
            ListNode nextNode = current.next;
            Lcurrent.next = previous;
            previous = current;
            current = nextNode;
        }
        return previous;
    }
}