class Solution {
    static boolean findEmptyCell(char[][] board , int [] emptyCell){
        for(int i = 0 ; i<9 ; i++){
            for(int j =0 ; j<9 ; j++){
                if(board[i][j]=='.'){
                    emptyCell[0]=i;
                    emptyCell[1]=j;
                    return true;
                }
            }
        }
        return false;
    }
    static boolean slove(char[][] board ){
        int [] emptyCell = new int[2];
        if(!findEmptyCell(board, emptyCell)){
            return true;
        }
        int rowIndex = emptyCell[0];
        int colIndex = emptyCell[1];

        for(int value = 1 ; value<=9 ; value++ ){
            char charValue = (char) (value+'0');
            if(isSafeToPlace(board, charValue, rowIndex, colIndex)){
                board[rowIndex][colIndex] = charValue;
                if(slove(board)==true){
                    return true;
                }
                board[rowIndex][colIndex] = '.';
            }
        }
        return false;
    }
    static boolean isSafeToPlace(char[][] board,char charValue,int rowIndex,int colIndex ){
        for(int col=0; col<9 ; col++){
            if(board[rowIndex][col]==charValue){
                return false;
            }
        }
        for(int row = 0 ; row<9 ; row++){
            if(board[row][colIndex]==charValue){
                return false;
            }
        }
        int stRow = rowIndex - rowIndex%3;
        int stcol = colIndex - colIndex%3;
        for(int i = 0 ; i<3 ; i++){
            for(int j = 0 ; j<3 ; j++){
                int actualRow = stRow+i;
                int actualcol = stcol+j;
                if(board[actualRow][actualcol]== charValue){
                    return false;
                }
            }
        }
        return true;
    } 
    public void solveSudoku(char[][] board) {
        slove(board);
        
    }
}