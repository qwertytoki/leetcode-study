
class Solution {

    public int numDecodings(String s) {
        // 配列を保持する
        int[] dp = new int[s.length() + 1];

        // 0桁の場合の処理
        dp[0] = 1;

        // 1桁の場合、0 以外はデコード可能
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        // 2桁以降は1桁目と、2桁の数字を確認する
        for (int i = 2; i < dp.length; i++) {
            if (s.charAt(i - 1) != '0') {
                // 1桁目は前の値を引き継ぐだけ
                dp[i] = dp[i - 1];
            }

            int twoDigit = Integer.valueOf(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                // 2桁目は、2つ前の値を引き継ぐ
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}
