class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) { // after last element of pushed, elements in popped need to be sorted reverse order in pushed.
        Stack<Integer> stack = new Stack<>();
        int pushed_idx = 0; int popped_idx = 0;
        while(pushed_idx < pushed.length){
            if(pushed[pushed_idx] == popped[popped_idx]){
                pushed_idx++;
                popped_idx++;
                continue;
            }
            if(!stack.isEmpty() && stack.peek() == popped[popped_idx]){
                stack.pop();
                popped_idx++;
            }
            else{
                stack.push(pushed[pushed_idx]);
                pushed_idx++;
            }
            
        }
        int tmp = 0;
        while(!stack.isEmpty()){
            tmp = stack.pop();
            if(tmp != popped[popped_idx]){
                return false;
            }
            popped_idx++;
        }
        return true;
    }
}