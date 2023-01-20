class Solution {
    public ListNode reverseList(ListNode head){
        return reverse(head,null);
    }

    private ListNode reverse(ListNode current, ListNode previous){
        if(current == null){
            return previous;
        }
        ListNode nextNode = current.next;
        current.next = previous;
        return reverse(nextNode,current);
    }
}