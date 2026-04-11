class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] dist = new int[rows][cols];
        int[][] vis = new int[rows][cols];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j,0});
                    vis[i][j] = 1;
                } else {
                    vis[i][j] = 0;
                }
            }
        }

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        while(!q.isEmpty()){
            int[] pos = q.poll();
            int x = pos[0], y=pos[1], cnt=pos[2];
            dist[x][y] = cnt;
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx<0 || ny<0 || nx>=rows || ny>=cols || mat[nx][ny] == 0) continue;
                if(vis[nx][ny]==0){
                    vis[nx][ny]=1;
                    q.add(new int[]{nx,ny,cnt+1});
                }
            }
        }

        return dist;

    }
}