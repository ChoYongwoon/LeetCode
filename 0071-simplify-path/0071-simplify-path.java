class Solution {
    public String simplifyPath(String path) {
        String[] tmp = path.split("/");
        String res = "";
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < tmp.length; i++){
            if (tmp[i].length() == 0 || tmp[i].compareTo(".") == 0){
                continue;
            }
            else if(tmp[i].compareTo("..")==0){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else{
                stack.push(tmp[i]);
            }
        }
        
        while(!stack.isEmpty()){
            res = "/" + stack.pop() + res;
        }
        if(res.length() == 0){
            res = "/";
        }
        
        return res;
    }
}