class Solution {    // Used priority queue to manage left candidates and right candidates
    public long totalCost(int[] costs, int k, int candidates) {
       if(2*candidates + k > costs.length){     // In this condition, all cost can be checked
            Arrays.sort(costs);                 // So, just pick the k smallest costs 
            long result = 0;
            for(int i = 0; i < k ;i++){
                result += costs[i];
            }
            return result;
        }
        else{ // We should check the smallest cost of left candidates and right candidates seperately
            // Use priority queue to do it fast!
            PriorityQueue<Integer> left = new PriorityQueue<>();
            PriorityQueue<Integer> right = new PriorityQueue<>();
            for(int i = 0; i < candidates; i++){    // Insert initial candidates
                left.add(costs[i]);
                right.add(costs[costs.length-1-i]);
            }
            int left_idx = left.size();             // index of the next candidate in left pq.
            int right_idx = costs.length-1-right.size(); // index of the next candidate in right pq.
            long result = 0;    

            // Calculate the result according to problem descriptions.
            // pq's peek is always the smallest cost.
            for(int i = 0; i < k; i++){
                if(left.peek() <= right.peek()){    // If the right's peek is larger
                    result += left.remove();        // pop the smallest element in left pq,
                    left.add(costs[left_idx++]);    // insert the new cost in left index, renew the left index
                }else{   // Resolve symmetrically
                    result += right.remove();       
                    right.add(costs[right_idx--]);
                }

            }
            return result;
        }
    }
}