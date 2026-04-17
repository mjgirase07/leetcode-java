class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<>();
        for(int i=0; i<numCourses; i++){adjLs.add(new ArrayList<>());}
        for(int[] pre : prerequisites){
            adjLs.get(pre[1]).add(pre[0]);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        for(int i=0; i<numCourses; i++){
            if(!vis[i]){
                if(dfs(i,vis,path,adjLs,ans)) return new int[0];
            }
        }

        Collections.reverse(ans);
        return ans.stream().mapToInt(i->i).toArray();
    }

    private boolean dfs(int node,boolean[] vis, boolean[] path, ArrayList<ArrayList<Integer>> adjLs, ArrayList<Integer> ans){
        vis[node] = path[node] = true;

        for(Integer it:adjLs.get(node)){
            if(!vis[it]){
                if(dfs(it,vis,path,adjLs,ans))
                    return true;
            } else if(path[it])
                return true;
        }
        ans.add(node);
        path[node]=false;
        return false;
    }
}