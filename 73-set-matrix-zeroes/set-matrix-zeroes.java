class Solution {
    public void setZeroes(int[][] matrix) {
        int[] row=new int[matrix.length],col=new int[matrix[0].length];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        //row
        for(int i=0; i<row.length; i++){
            if(row[i]==1){
                for(int c=0; c<col.length;c++){
                    matrix[i][c] = 0;
                }
            }
        }

        //col
        for(int i=0; i<col.length; i++){
            if(col[i]==1){
                for(int r=0; r<row.length;r++){
                    matrix[r][i] = 0;
                }
            }
        }
            
        
    }
    
    void mark(int[][] matrix, int row, int col){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if((i==row || j==col) && matrix[i][j]!=0){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}