/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
} */

class Solution {
    public static void transformTree(Node root) {
        // code here
        ArrayList<Node> list = new ArrayList<>();
        dfs(root,list);
        int sum = 0;
        int x;
        for(int i= list.size()-1;i>=0;i--){
            x = list.get(i).data;
            list.get(i).data = sum;
            sum += x;
        } // bus values ko change krne se he ho jayega as nodes toh whi pe hai
        
    }
    private static void dfs(Node root,ArrayList<Node> list){
        if(root == null) return;
        dfs(root.left,list);
        list.add(root);
        dfs(root.right,list);
    }
}