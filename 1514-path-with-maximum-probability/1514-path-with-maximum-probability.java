class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) { 
        Map<Integer, Set<Pair>> graph = buildGraph(n, edges, succProb);     // Build Graph
        return dijkstra(n, start, end, graph);                              // Dijkstra to compute the maximum probability
    }

    public Map<Integer, Set<Pair>> buildGraph(int n, int[][] edges, double[] succProb){ // Build graph (adjacent HashTable)
        // This process is for making easier to get adjacent vertices
        Map<Integer, Set<Pair>> graph = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            int[] edge = edges[i];
            if(graph.containsKey(edge[0])){
                graph.get(edge[0]).add(new Pair(edge[1], succProb[i]));
            }else{
                Set<Pair> newSet = new HashSet<>();
                newSet.add(new Pair(edge[1], succProb[i]));
                graph.put(edge[0], newSet);
            }
            if(graph.containsKey(edge[1])){
                graph.get(edge[1]).add(new Pair(edge[0], succProb[i]));
            }else{
                Set<Pair> newSet = new HashSet<>();
                newSet.add(new Pair(edge[0], succProb[i]));
                graph.put(edge[1], newSet);
            }
        }
        return graph;
    }

    public double dijkstra(int n, int start, int end, Map<Integer, Set<Pair>> graph) {  // Calculate Maximum probability
        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair p1, Pair p2) -> p1.dist < p2.dist ? 1: -1);  // maximum probability vertex is located in first space
        Pair[] vertices = new Pair[n];  // vertices used in dijkstra algorithm
        for(int i = 0; i < n; i++){
            vertices[i] = new Pair(i, 0);
            vertices[i].dist = -1;
        }
        vertices[start].dist = 1;
        pq.offer(vertices[start]);

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            if(curr.vertex == end){
                return curr.dist;
            }
            Set<Pair> adjs = graph.get(curr.vertex);
            if(adjs == null){  
                continue;
            }
            for(Pair adj : adjs){
                int adjVertex = adj.vertex;
                if(curr.dist * adj.prob > vertices[adjVertex].dist){    // relaxation
                    pq.remove(vertices[adjVertex]);
                    vertices[adjVertex].dist = curr.dist * adj.prob;
                    pq.offer(vertices[adjVertex]);
                }
            }
        }
        return 0;
    }

    class Pair{ // custom inner class to manage vertices
        int vertex;
        double prob;
        double dist;
        public Pair(int v, double p){
            vertex = v;
            prob = p;
        }

        @Override
        public int hashCode() {
            return vertex % 101;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Pair other = (Pair) obj;
            if (vertex != other.vertex)
                return false;
            return true;
        }
    }
}