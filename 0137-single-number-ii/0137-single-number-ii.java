class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> candidates = new HashSet<>();
        Set<Integer> folded = new HashSet<>();

        for(int num : nums){
            if(candidates.remove(num)){
                folded.add(num);
            }
            else if(folded.contains(num)){
            }
            else{
                candidates.add(num);
            }
        }

        Iterator<Integer> iter = candidates.iterator();
        return iter.next();
    }
}