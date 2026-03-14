/*
class Node {
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    // public void dfs(Node root,ArrayList<Integer>ans){
    //     if(root==null){
    //         return;
    //     }
    //     dfs(root.left,ans);
    //     ans.add(root.data);
    //     dfs(root.right,ans);
    // }
    public ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer>ans = new ArrayList<>();
        Node curr = root;
        while(curr!=null){
            if(curr.left!=null){
                Node pred = curr.left;
                while(pred.right !=null && pred.right!=curr){
                    pred = pred.right;
                }
                 if(pred.right==null){
                        pred.right = curr; // linking
                        curr = curr.left;
                    }
                    else{
                        pred.right = null; // unlinking
                        ans.add(curr.data);
                        curr = curr.right;
                    }
            }
            else{
                ans.add(curr.data);
                curr = curr.right;
            }
        }
        return ans;
        
        
        
        
        
        // dfs(root,ans);
        // return ans;
        
        // this is inorder using stack
        
        // Stack<Node> st = new Stack<>();
        // Node curr = root;
        // while(st.size()>0 || curr !=null){
        //     if(curr != null){
        //         if(curr.left !=null){
        //           st.push(curr);
        //           curr = curr.left;
        //         }
        //         else{
        //             ans.add(curr.data);
        //             curr = curr.right;
        //         }
                
        //     }
        //     else{
        //         Node top = st.pop();
        //         ans.add(top.data);
        //         curr = top.right;
        //     }
        // }
        // return ans;
        
        // inorder using morris traversal
        
    }
}