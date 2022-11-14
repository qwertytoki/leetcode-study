import java.util.*;

/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */

// @lc code=start
class Solution {
    static Map<String, Integer> values = new HashMap<>();
    static {
        values.put("I", 1);
        values.put("V", 5);
        values.put("X", 10);
        values.put("L", 50);
        values.put("C", 100);
        values.put("D", 500);
        values.put("M", 1000);
        values.put("IV", 4);
        values.put("IX", 9);
        values.put("XL", 40);
        values.put("XC", 90);
        values.put("CD", 400);
        values.put("CM", 900);
    }

    // 1 すべての文字を含めたMapを作成
    // 2 受け取った文字をループに掛ける
    // 3 2文字に該当しないかをチェック
    // 4 1文字に該当しないかをチェック
    // 5 3,4の結果をresult integerにつめていく
    
    public int romanToInt(String s) {
        int sum =0;
        int i=0;
        while(i< s.length()){
            //double symbol check
            if(i< s.length()-1){
                String doubleSymbol = s.substring(i,i+2);
                if(values.containsKey(doubleSymbol)){
                    sum += values.get(doubleSymbol);
                    i +=2;
                    continue;
                }
            }
            //single symbol check
            String singleSymbol = s.substring(i,i+1);
            if(values.containsKey(singleSymbol)){
                sum += values.get(singleSymbol);
                i++;
            
            }
        }        
        return sum;
    }
}
// @lc code=end

