/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        ArrayList<Node>list = new ArrayList<>();
        ArrayList<Node>ans = new ArrayList<>();
        dfs(root,list);
        Node pred = null;
        Node succ = null;
        for(int i=0;i<list.size();i++){
            if(list.get(i).data<key){
                pred = list.get(i);
            }
            if(list.get(i).data>key){
                succ = list.get(i);
                break;
            }
        }
        ans.add(pred!=null ? pred : new Node(-1)); // ternary operator same as if else
        ans.add(succ!=null ? succ : new Node(-1));
       
       
      
       return ans;
    }

    private void dfs(Node root,ArrayList<Node>list){
        if(root==null) return;
        dfs(root.left,list);
        list.add(root);
        dfs(root.right,list);
    }
}