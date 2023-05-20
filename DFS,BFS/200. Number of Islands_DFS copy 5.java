class Solution {
    public int numIslands(char[][] grid) {
        // 上下左右全部埋めていくやつ
        // DFS BFS
        // BFSはQUEUEかなんかつかってとく
        
        // DFS
        if(grid.length ==0){
            return 0;
        }
        int rowEnd = grid.length;
        int colEnd = grid[0].length;
        int numberOfIslands = 0;
        for(int i = 0; i< rowEnd;i++){
            for(int j = 0; j<colEnd; j++){
                if(grid[i][j]=='1'){
                    numberOfIslands++;
                    land(grid, i,j,rowEnd, colEnd);
                }
            }
        }
        return numberOfIslands;
    }

    private void land(char[][] grid, int row, int col, int rowEnd, int colEnd){
        if(grid[row][col] == '0'){
            return;
        }
        grid[row][col] = '0';
        if(row-1 >=0){
            land(grid,row-1, col, rowEnd, colEnd);
        }
        if(row+1 <rowEnd){
            land(grid,row+1, col, rowEnd, colEnd);    
        }
        if(col-1 >= 0){
            land(grid,row, col-1, rowEnd, colEnd);
        }        
        if(col+1 < colEnd){
            land(grid,row, col+1, rowEnd, colEnd);
        }
    }
}

// time: O(row * col)
// space:O(row * col)

/**
このコードの空間計算量についてですが、主にDFSのリカーション・スタックによる深さが考慮されます。最悪の場合、すべてのセルが島（つまり全てのセルが '1'）である場合、最大の深さは行数と列数の合計となります（長い「L」形状の島を考えてみてください）。したがって、最悪の場合の空間計算量はO(row + col)となります。
ただし、ここで重要な点は、引数として渡されるgrid自体は既存のメモリを使用しており、新たに確保されるわけではないため、そのサイズは空間計算量に含まれません。したがって、答えはO(row + col)となります。
なお、Javaでは関数呼び出し自体もスタックフレームを消費しますので、これも考慮に入れると、最悪の場合にはO(row * col)となりますが、これは異常ケース（すべてのセルが互いに隣接する異なる島である場合）を想定したものであり、一般的なケースでは上述のO(row + col)が適用されます。
 */