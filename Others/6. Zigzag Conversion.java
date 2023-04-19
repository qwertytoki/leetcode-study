class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }

        int n = s.length();

        //ここがキモ
        int sections = (int)Math.ceil(n/(2*numRows - 2.0)); //小数点切り上げ
        int numCols =  sections * (numRows -1);

        char[][] matrix = new char[numRows][numCols];
        for(char[] row : matrix){
            Arrays.fill(row, ' ');
        }

        int currRow = 0, currCol =0;
        int currStringIndex = 0;

        // ジグザグに数値をおいていく
        while(currStringIndex < n){
            //縦に降りる動作
            while(currRow < numRows && currStringIndex < n){
                matrix[currRow][currCol] = s.charAt(currStringIndex);
                currRow++;
                currStringIndex++;
            }
            currRow -=2; //行き過ぎてるので戻る
            currCol++; // 斜めに上がる動作開始
            while(currRow > 0 && currCol < numCols && currStringIndex < n){
                matrix[currRow][currCol] = s.charAt(currStringIndex);
                currRow--;
                currCol++;
                currStringIndex++;
            }
        }

        // 数え上げる動作
        StringBuilder builder = new StringBuilder();
        for(char[] row : matrix){
            for(char col: row){
                if(col != ' '){
                    builder.append(col);
                }
            }
        }
        return builder.toString();

    }
}