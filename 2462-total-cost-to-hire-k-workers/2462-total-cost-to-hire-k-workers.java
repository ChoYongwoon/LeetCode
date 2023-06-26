class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
       if(2*candidates + k > costs.length){
            Arrays.sort(costs);
            long result = 0;
            for(int i = 0; i < k ;i++){
                result += costs[i];
            }
            return result;
        }
        else{
            PriorityQueue<Integer> left = new PriorityQueue<>();
            PriorityQueue<Integer> right = new PriorityQueue<>();
            for(int i = 0; i < candidates; i++){
                left.add(costs[i]);
                right.add(costs[costs.length-1-i]);
            }
            int left_idx = left.size();
            int right_idx = costs.length-1-right.size();
            long result = 0;

            for(int i = 0; i < k; i++){
                if(left.peek() <= right.peek()){
                    result += left.remove();
                    left.add(costs[left_idx++]);
                }else{
                    result += right.remove();
                    right.add(costs[right_idx--]);
                }

            }
            return result;
        }
    }
}