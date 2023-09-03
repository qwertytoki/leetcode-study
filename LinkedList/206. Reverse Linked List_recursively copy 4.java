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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return node;
    }
}


/**
リスト`1->2->3->4->5`に対しての再帰の流れを詳細に説明します。

1. 最初に、`1`を`head`として関数を呼び出します。
   
   - このとき`1`の`next`が`2`なので、`reverseList(head.next)`を呼び出すと、`2`を`head`として再帰的に関数が呼び出されます。

2. 次に、`2`を`head`として関数を呼び出します。
   
   - このとき`2`の`next`が`3`なので、再び`reverseList(head.next)`を呼び出して、`3`を`head`として関数が呼び出されます。

3. 今度は`3`を`head`として関数を呼び出します。

   - `3`の`next`は`4`なので、再び`reverseList(head.next)`を呼び出し、`4`を`head`として関数が呼び出されます。

4. `4`を`head`として関数を呼び出します。
   
   - `4`の`next`は`5`なので、再び`reverseList(head.next)`を呼び出して、`5`を`head`として関数が呼び出されます。

5. 最後に、`5`を`head`として関数を呼び出します。
   
   - このとき、`5`の`next`は`null`なのでベースケースに該当し、`5`をそのまま返します。

ここから、再帰の「戻り」のフェーズに入ります。

6. `4`を`head`とした関数の呼び出しに戻ります。
   
   - ここで`head.next.next = head;`を実行すると、`5`の`next`を`4`に設定します。
   - そして、`head.next = null;`を実行すると、`4`の`next`を`null`にします。

   この時点で部分的なリストは`5->4`となります。

7. `3`を`head`とした関数の呼び出しに戻ります。
   
   - 同様の操作を行い、`4`の`next`を`3`に設定し、`3`の`next`を`null`にします。

   この時点での部分的なリストは`5->4->3`です。

8. `2`を`head`とした関数の呼び出しに戻ります。
   
   - 同様の操作を行い、`3`の`next`を`2`に設定し、`2`の`next`を`null`にします。

   この時点での部分的なリストは`5->4->3->2`です。

9. 最後に、`1`を`head`とした関数の呼び出しに戻ります。
   
   - 同様の操作を行い、`2`の`next`を`1`に設定し、`1`の`next`を`null`にします。

   ここでのリストは`5->4->3->2->1`と完全に逆転します。

このように、再帰が最も深い部分（この場合`5`）まで進んだ後に、一つずつ戻りながらリストを逆順にしていきます。
 */