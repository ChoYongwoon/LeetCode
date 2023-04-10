class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0){return false;}
        Stack<Character> stack = new Stack<>();
        
        char cur = '\n'; char comp = '\n';
        for(int i = 0; i < s.length(); i++){
            cur = s.charAt(i);
            if(cur == '(' || cur == '{' || cur == '['){
                stack.push(cur);
            }else{
                if(stack.empty()){return false;}
                comp = stack.pop();
                if(comp == '(' && cur == ')'){
                    continue;
                }
                else if(comp == '{' && cur == '}'){
                    continue;
                }
                else if(comp == '[' && cur == ']'){
                    continue;
                }
                return false;
            }
        }
        if(!stack.empty()){return false;}
        return true;
    }
}