class Solution {
    public boolean exist(char[][] board, String word) {
        int rowEnd = board.length;
        int colEnd = board[0].length;
        boolean result = false;
        for(int row = 0; row< rowEnd ; row++){
            for(int col = 0; col< colEnd; col++){
                if(board[row][col] ==word.toCharArray()[0]){
                    result = dig(row, col, board, word, 0);
                    if(result){
                        return true;
                    }                    
                }
            }
        }
        return false;
    }

    private boolean dig(int row, int col, char[][] board, String word, Integer index){
        int rowEnd = board.length;
        int colEnd = board[0].length;
        if(index == word.length()){
            return true;
        }
        char[] wordChar = word.toCharArray();
        if(row <0 || row >= rowEnd || col<0 || col >= colEnd 
            || board[row][col] != wordChar[index]){
            return false;
        }
        char temp = board[row][col];
        board[row][col] = '#';
        boolean found =  dig(row+1, col, board, word, index+1) ||
        dig(row-1, col, board, word, index+1) ||
        dig(row, col+1, board, word, index+1) ||
        dig(row, col-1, board, word, index+1);
        board[row][col] = temp; 
        return found;
    }
}