class Solution {
    private void dfs(int node, ArrayList<ArrayList<Integer>> adjLs, int[] vis){
        vis[node] = 1;
        for(Integer it:adjLs.get(node)){
            if(vis[it] == 0){
                dfs(it, adjLs,vis);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;

        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<ArrayList<Integer>>();

        for(int i=0; i<v; i++){
            adjLs.add(new ArrayList<Integer>());
        }

        //matrix to adjls conversion
        for(int i=0; i<v; i++){
            for(int j=0;j<v; j++){
                if(isConnected[i][j] == 1 && i!=j){
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }

        int cnt = 0;
        int[] vis = new int[v];
        for(int i=0; i<v; i++){
            if(vis[i] == 0){
                cnt++;
                dfs(i, adjLs, vis);
            }
        }
        return cnt;
    }
}