// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

/* Should return minimum distance between a and b
   in a tree with given root*/
class GfG {
    int findDist(Node root, int a, int b) {
        if(root == null) return 0;
        // Your code here
        int[] arr = new int[2];
        Node lca = lca(root,a,b);
        traversal(lca,a,b,0,arr);
        return arr[0] + arr[1];
        
    }
    private Node lca(Node root, int p ,int q){
        if(root == null) return null;
        if((root.data == p) || (root.data == q)) return root;
        Node left  = lca(root.left,p,q);
        Node right = lca(root.right,p,q);
        if(left != null && right != null) return root;
        else if(left == null) return right;
        else return left;
    }
    private void traversal(Node root, int p,int q, int level , int[] arr){
        if(root == null) return;
        if(root.data == p) arr[0] = level;
        if(root.data == q) arr[1] = level;
        traversal(root.left,p,q,level+1,arr);
        traversal(root.right,p,q,level+1,arr);
        
    }
}