class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) { // Use stack to check
        Stack<Integer> stack = new Stack<>();
        int pushed_idx = 0; int popped_idx = 0;                         
        while(pushed_idx < pushed.length){                      
            if(pushed[pushed_idx] == popped[popped_idx]){               // the comparing value is smae, execute push() and pop() which is same with both index ++
                pushed_idx++;
                popped_idx++;
                continue;                                               // then, jump to next comparison
            }
            if(!stack.isEmpty() && stack.peek() == popped[popped_idx]){ // if the top of stack is smae with target value in popped, execute pop(), popped_idx++
                stack.pop();
                popped_idx++;
            }
            else{                                                       // to all other cases, push the current target value to stack
                stack.push(pushed[pushed_idx]);
                pushed_idx++;
            }
            
        }
        while(!stack.isEmpty()){                                        // after above sequence, check the value after popped_idx is sorted as reverse order of pushe               
            if(stack.pop() != popped[popped_idx]){
                return false;                                           // if not, false
            }
            popped_idx++;
        }
        return true;                                                    // all test finish -> true
    }
}