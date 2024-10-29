
class Solution {

    public int majorityElement(int[] nums) {
        int candidate = nums[0], count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidate = num;
                    count = 1;
                }
            }
        }
        return candidate;
    }
    /**
     * なぜこれで正しい要素が見つかるのか? •	候補要素が多数要素である場合、それは配列全体を通じて他の要素に「打ち消されない」ほど出現回数が多いです。
     * •	異なる要素が現れるとカウントを減らしますが、多数要素は最終的にカウントがプラスに傾くので 必ず候補に残ります。
     * →なるほど、カウントを返す必要がなく、Majorityの数値を返すだけだからこれでいいんだ。
     */

}
