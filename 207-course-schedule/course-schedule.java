class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        for (int[] pre : prerequisites)
            adj.get(pre[1]).add(pre[0]);
        
        boolean[] vis = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        for(int i=0; i<numCourses; i++){
            if(!vis[i]){
                if(dfs(i,path,vis,adj)) return false;
            }
        }
        return true;
    }

    private boolean dfs(int node,boolean[] path, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[node]=path[node] = true;
        for(Integer adjNode : adj.get(node)){
            if(!vis[adjNode]){
                if(dfs(adjNode,path,vis,adj)){
                    return true;
                }
            } else if(path[adjNode]){
                return true;
            }
        }
        path[node] = false;
        return false;
    }
}