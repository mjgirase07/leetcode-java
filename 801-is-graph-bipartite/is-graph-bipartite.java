class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        for(int i=0; i<n; i++){
            if(color[i] != 0) continue;

            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            color[i] = 1;

            while(!q.isEmpty()){
                int node = q.poll();
                for(Integer it:graph[node]){
                    if(color[it]==0){
                        color[it]=color[node]==1?2:1;
                        q.add(it);
                    }
                    else if(color[it]!=0 && color[it]==color[node]) return false;
                }
            }
        }
        return true;
    }
}