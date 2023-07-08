class Solution {
    private char[][]board;
    private int rows;
    private int cols;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;
        for(int row = 0; row <rows;row++){
            for(int col =0; col <cols; col++){
                if(backtrack(row,col, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(int row, int col, String word, int index){
        if(index >= word.length()){
            return true;
        }
        if(row < 0 || row== rows|| col<0 || col == cols || board[row][col] != word.charAt(index)){
            return false;
        }

        board[row][col] = '#';
        int[] rowOffsets = {0,1,0,-1};
        int[] colOffsets = {1,0,-1,0};
        for(int i = 0; i<4; i++){
            if(backtrack(row+rowOffsets[i], col+colOffsets[i], word, index+1)){
                return true;
            }
        }

        board[row][col] = word.charAt(index);
        return false;
    }
}