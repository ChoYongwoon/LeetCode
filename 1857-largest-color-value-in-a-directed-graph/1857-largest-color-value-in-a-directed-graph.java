class Solution { 
    public int largestPathValue(String colors, int[][] edges) { // using topological sort
        // we can find cycle, and possible path with largest color value.
        // To implement topological sort, use queue(BFS).
        
        Arrays.sort(edges, new Comparator<int[]>() { // sort edges in terms of in-term(first-term) to use array indexing
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]!=o2[0] ? o1[0]-o2[0] : o1[1]-o2[1];}}
        );
        int[] outdegree = new int[colors.length()]; // In edges, the edges from 'i' is in (outdegree[i-1]:outdegree[i])
        int[] indegree = new int[colors.length()]; // Array for counting indegree edges.
        int visit_count = 0; // After topological sort, if visit_count != # of verteices, it means there is a cycle.
        for(int i = 0; i < edges.length; i++){ // check indegree, outdegree
            indegree[edges[i][1]]++;
            outdegree[edges[i][0]]++;
        }
        for(int i = 1; i < outdegree.length; i++){ // cumulative sum
            outdegree[i] += outdegree[i-1];
        }
        
        int[][] res_dp = new int[indegree.length][26]; // dp array to find largest color value
        // res_dp[vertex][alpha] means the # of occurences of alpha following the path to vertex.
        for(int i = 0; i < colors.length(); i++){ // initialize
            res_dp[i][colors.charAt(i)-'a']++;
        }
        
        Queue<Integer> tpsort = new LinkedList<>(); // Queue for topological sort.
        for(int i = 0; i < indegree.length; i++){   // push vertices without edges toward them.
            if(indegree[i] == 0){
                tpsort.offer(i);
            }
        }
        
        int max = 0; int out = 0; int in = 0;       // max will be returned as the result of the function
        while(!tpsort.isEmpty()){                   // topological sort
            in = tpsort.poll();
            visit_count++;
            if(in == 0){                            // In case '0', edges from 0 are in edges[0:outdegree[in]]
                for(int i = 0; i < outdegree[in]; i++){ 
                    out = edges[i][1];
                    for(int k = 0; k < 26; k++){    // update dp
                        res_dp[out][k] = Math.max(res_dp[out][k], res_dp[in][k] + (colors.charAt(out)-'a'==k? 1: 0));
                    }
                    indegree[out]--;
                    if(indegree[out]==0){tpsort.offer(out);}
                }
            }else{                                  // All the case but '0', edges from 'in' are in edges[outdegree[in-1]:outdegree[in]]
                for(int i = outdegree[in-1]; i < outdegree[in]; i++){
                    out = edges[i][1];
                    for(int k = 0; k < 26; k++){    // update dp
                        res_dp[out][k] = Math.max(res_dp[out][k], res_dp[in][k] + (colors.charAt(out)-'a'==k? 1: 0));
                    }
                    indegree[out]--;
                    if(indegree[out]==0){tpsort.offer(out);}
                }
            }
            max = Math.max(max, Arrays.stream(res_dp[in]).max().getAsInt());    // renew the max value
        }
        
        
        if(visit_count != indegree.length){return -1;}  // there is a cycle.
        else{return max;}                               // no cycle -> return max
    }
}