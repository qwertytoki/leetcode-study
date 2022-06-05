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
    public ListNode deleteDuplicates(ListNode head) {
        // headの前に偽のNodeを用意する
        ListNode sentinel = new ListNode(0, head);
        ListNode pred = sentinel;
        
        while(head != null){
//             今のValと次のValが同じだったら
            if(head.next != null && head.val == head.next.val){
//                  同じの間だけ次へと進ませ続ける
                while(head.next != null && head.val == head.next.val){
                    head = head.next;    
                }
//                 nextのValがちがうあたいになったので、そのNodeをpred.nextにいれて、次に進ませる
                pred.next = head.next;    
            } else{
                pred = pred.next;
            }
            head = head.next;
        }
//         作成した偽Headの次が本当のHeadなので、それを返してあげる
        return sentinel.next;
    }
}