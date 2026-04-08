class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int m = image.length; //rows
        int n = image[0].length; //col 
        int toColor = image[sr][sc];
        if(toColor == color) return image;
        Queue<int[]> queue = new LinkedList<>();
 

        queue.add(new int[]{sr,sc});
        image[sr][sc] = color;
        //4 directions
        int[] dx = {0,0,1,-1}; 
        int[] dy = {1,-1,0,0};

        

        while(!queue.isEmpty()){
                int[] pos = queue.poll();
                int x = pos[0], y=pos[1];
                for(int d=0; d<4; d++){
                    int nx = x+dx[d];
                    int ny = y+dy[d];
                    if(nx<0 || ny<0 || nx>=m || ny>=n || image[nx][ny] != toColor){
                        continue;
                    }
                        image[nx][ny] = color;
                        queue.add(new int[]{nx,ny});
                }
        } 
        return image;
    }
}