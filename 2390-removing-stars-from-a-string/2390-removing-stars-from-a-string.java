class Solution {
    public String removeStars(String s) { // Use stack
        Stack<Character> stack =new Stack<>();  // Stack to store ordered non-star characters
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '*'){ // if character at ith  remove nearest non-star character
                stack.pop();
            }else{  // if non-star character, push to Stack
                stack.push(s.charAt(i));
            }
        }
        String res = "";
        while(!stack.empty()){ // make result;
            res = stack.pop() + res;
        }
        return res;
    }
}