class Solution {
    public boolean exist(char[][] board, String word) {
        int rowEnd = board.length;
        int colEnd = board[0].length;
        char[] wordChar = word.toCharArray(); // Cache the word as char array

        for(int row = 0; row < rowEnd; row++) {
            for(int col = 0; col < colEnd; col++) {
                if(dig(row, col, board, wordChar, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dig(int row, int col, char[][] board, char[] wordChar, int index) {
        if(index == wordChar.length) {
            return true;
        }
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length 
           || board[row][col] != wordChar[index]) {
            return false;
        }
        char temp = board[row][col];
        board[row][col] = '#';
        
        boolean found = dig(row + 1, col, board, wordChar, index + 1);
        if (!found) found = dig(row - 1, col, board, wordChar, index + 1);
        if (!found) found = dig(row, col + 1, board, wordChar, index + 1);
        if (!found) found = dig(row, col - 1, board, wordChar, index + 1);
        
        board[row][col] = temp; 
        return found;
    }
}