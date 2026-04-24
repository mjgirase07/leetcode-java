class Solution {
    public int[] findOrder(int V, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<>();
        for(int i=0; i<V; i++){adjLs.add(new ArrayList<>());}
        for(int[] pre : prerequisites){
            adjLs.get(pre[1]).add(pre[0]);
        }

        int[] indegree = new int[V];
        for(int i=0; i<V; i++){
            for(Integer it : adjLs.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<V; i++){
            if(indegree[i] == 0) q.add(i);
        }

        int i=0;
        int[] topo = new int[V];
        while(!q.isEmpty()){
            int node = q.poll();
            topo[i++] = node;
            for(Integer it:adjLs.get(node)){
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            } 
        }
        if(i != V) return new int[0];
        return topo;
    }
}