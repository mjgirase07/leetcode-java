class Solution {

    static int[] dRow = {0,1,0,-1};
    static int[] dCol = {-1,0,1,0};

    public boolean exist(char[][] board, String word) {
        
        boolean[][] vis = new boolean[board.length][board[0].length];
       

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(i,j,0,vis,board,word)) return true;
                }
            }
        }
        return false;
    }

    

    static boolean dfs(int row, int col,int idx, boolean[][] vis, char[][] board,String word){

        if(idx == word.length()) return true;

         if(row<0 || col<0 || row>=board.length || col>=board[0].length){
            return false;
        }

        if(vis[row][col]) return false;

        if(board[row][col] != word.charAt(idx)) return false;

        vis[row][col] = true;

        for(int i=0; i<4; i++){
            int nr = row+dRow[i];
            int nc = col+dCol[i];

            if(dfs(nr,nc,idx+1,vis,board,word)){
                return true;
            }
        }

        vis[row][col] = false;
        

        return false;

    }


}