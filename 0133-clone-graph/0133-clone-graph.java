/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) { // Using dfs
        if(node == null){return null;}
        Node[] check = new Node[101]; // because Node.val is in [1,100]. For checking whether the node is visited or not
        for(int i = 0; i < 101; i++){ // initialize as null
            check[i] = null; 
        }
        
        Node newNode = new Node(node.val);
        check[newNode.val] = newNode;
        for(Node neighbor : node.neighbors){
            newNode.neighbors.add(dfs(neighbor, check)); // add connected Node which contains copied neighbors in edges list .
        }
        return newNode;
    }
    
    public Node dfs(Node ref, Node[] check){ // return connected vertex
        if(check[ref.val] != null){return check[ref.val];} // if the node is visited before, return exsisting node
     
        Node newNode = new Node(ref.val); // make new node
        check[newNode.val] = newNode; // mark visited
        for(Node neighbor : ref.neighbors){ // add connected Node recursively.
            newNode.neighbors.add(dfs(neighbor, check));
        }
        return newNode;
    }
}