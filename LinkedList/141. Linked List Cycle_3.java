//the simplest solution with using HashSet

public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> alreadySeenSet = new HashSet<>();
        while(head != null){
            if(alreadySeenSet.contains(head)){
                return true;
            }
            alreadySeenSet.add(head);
            head = head.next;
        }
        return false;
    }
}