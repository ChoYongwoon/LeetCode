class Solution {
    public String simplifyPath(String path) { 
        String[] tmp = path.split("/");                                 // first, split the input by '/'
        String res = "";                                                // String to be retuned.
        Stack<String> stack = new Stack<>();                            // Using stack to handle ".."
        for(int i = 0; i < tmp.length; i++){                            
            if (tmp[i].length() == 0 || tmp[i].equals(".")){            // If a piece contains nothing or just "." pass
                continue;
            }
            else if(tmp[i].equals("..")){                               // If a piece is "..", execute pop() to trace back
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else{                                                       // In normal case, push the directory to stack
                stack.push(tmp[i]);
            }
        }
        
        while(!stack.isEmpty()){                                        // Make the result
            res = "/" + stack.pop() + res;
        }
        if(res.length() == 0){                                          // If there's nothing to return, return "/"
            res = "/";
        }
        
        return res;
    }
}