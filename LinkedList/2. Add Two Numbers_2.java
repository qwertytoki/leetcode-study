class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode();
        ListNode current = sentinel;
        int carry = 0;

        while( l1 != null || l2 != null || carry != 0){ //carry != 0 is important.. 
            int a = l1 != null ? l1.val:0;
            int b = l2 != null ? l2.val:0;
            int sum = a + b + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            // push l1 and l2
            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
        }
        return sentinel.next;
    }
}