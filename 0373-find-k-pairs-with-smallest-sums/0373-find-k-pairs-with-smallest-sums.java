class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int size1 = nums1.length;
        int size2 = nums2.length;
        
        List<List<Integer>> smallestPairs = new LinkedList<>();
        
        PriorityQueue<Pair> smallestHeap = new PriorityQueue<>();
        Set<Pair> visited = new HashSet<>();
        
        smallestHeap.offer(new Pair(nums1, nums2, 0, 0));
        visited.add(new Pair(nums2, nums2, 0, 0));
        
        while (!smallestHeap.isEmpty() && k-- > 0){
            Pair peek = smallestHeap.poll();
            int i = peek.num1;
            int j = peek.num2;
            
            smallestPairs.add(List.of(nums1[i], nums2[j]));
            
            if (i + 1 < size1 && !visited.contains(new Pair(nums1, nums2, i + 1, j))) {
                smallestHeap.offer(new Pair(nums1, nums2, i + 1, j));
                visited.add(new Pair(nums1, nums2, i + 1, j));
            }

            if (j + 1 < size2 && !visited.contains(new Pair(nums1, nums2, i , j + 1))) {
                smallestHeap.offer(new Pair(nums1, nums2, i , j + 1));
                visited.add(new Pair(nums1, nums2, i , j + 1));
            }
        }
            
            
        return smallestPairs;
    }

    public void appendElement(List<List<Integer>> tdlist, int i, int j){
        List<Integer> newElement = new LinkedList<>();
        newElement.add(i);
        newElement.add(j);
        tdlist.add(newElement);
    }

    class Pair implements Comparable<Pair>{
        int num1;
        int num2;
        int sum;
        public Pair(int[] nums1, int[] nums2, int i, int j){
            num1 = i;
            num2 = j;
            sum = nums1[i]+nums2[j];
        }

        @Override
        public int compareTo(Pair target){
            return this.sum - target.sum;
        }
        
        @Override
		public int hashCode() {
			return num1 + num2 + sum;
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
			if (num1 != other.num1)
				return false;
			if (num2 != other.num2)
				return false;
			return true;
		}
    }
}