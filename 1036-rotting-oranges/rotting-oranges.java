class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid.length==0) return 0;
        int m = grid.length; //rows
        int n = grid[0].length; //col 
        int total = 0; //rotten + fresh oranges
        int count = 0; //cnt of rotten oranges by us
        Queue<int[]> rotten = new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] !=0) total++;
                if(grid[i][j]==2){
                    rotten.add(new int[]{i,j});
                }
            }
        }  
        //4 directions
        int[] dx = {0,0,1,-1}; 
        int[] dy = {1,-1,0,0};

        int time = 0; //total time for rotting all the oranges

        while(!rotten.isEmpty()){
            int k = rotten.size();
            count += k;
            for(int i=0; i<k; i++){
                int[] pos = rotten.poll();
                int x = pos[0], y=pos[1];
                for(int d=0; d<4; d++){
                    int nx = x+dx[d];
                    int ny = y+dy[d];
                    if(nx<0 || ny<0 || nx>=m || ny>=n || grid[nx][ny] !=1){
                        continue;
                    }
                    grid[nx][ny] = 2;
                    rotten.add(new int[]{nx,ny});
                }
            }
            if(!rotten.isEmpty()) time++;
        } 
        return total==count? time : -1;
    }
}