class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        int n = s.length();
        // Math.ceil は切り上げ (ceiling)
        // 2引いてるのは、上と下か被ってるから
        int sections = (int) Math.ceil(n/ (2 * numRows - 2.0));
        // colはnumRowより1小さくなる
        int numCols = sections * (numRows-1);
        
        char[][] matrix = new char[numRows][numCols];
        for(char[] cArr : matrix){
            Arrays.fill(cArr,' ');
        }

        int currR = 0;
        int currC = 0;
        int currStringIndex = 0;

        while(currStringIndex < n){
            // 下に降りる
            while(currR < numRows && currStringIndex < n){
                matrix[currR][currC] = s.charAt(currStringIndex);
                currR++;
                currStringIndex++;
            }
            // 一個上に移動
            currR -= 2;
            currC++;
            // 斜めに上がる
            while(currR > 0 && currC < numCols && currStringIndex < n){
                matrix[currR][currC] = s.charAt(currStringIndex);
                currR--;
                currC++;
                currStringIndex++;
            }
        }

        //最後にStringBuilderでResult構築する
        StringBuilder result = new StringBuilder();
        for(char[] row : matrix){
            for(char c: row){
                if(c != ' '){
                    result.append(c);    
                }
            }
        }
        return result.toString();
    }
}