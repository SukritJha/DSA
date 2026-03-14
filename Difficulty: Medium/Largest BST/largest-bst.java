// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }
class find{
    int max;
    int min;
    int size;
    boolean isBST;
    find(int max,int min, int size,boolean isBST){
        this.max = max;
        this.min =min;
        this.size = size;
        this.isBST = isBST;
    }
}


class Solution {

    // Return the size of the largest sub-tree which is also a BST
    static int maxsize;
    static int largestBst(Node root) {
        maxsize =0;
        helper(root);
        return maxsize;
    }
    private static find helper(Node root){
        if(root == null) return new find(Integer.MIN_VALUE,Integer.MAX_VALUE,0,true);
        find lst = helper(root.left);
        find rst = helper(root.right);
        int max = Math.max(root.data,Math.max(lst.max,rst.max));
        int min = Math.min(root.data,Math.min(lst.min,rst.min));
        boolean isBST = root.data>lst.max && root.data<rst.min && lst.isBST && rst.isBST;
        int size = 1 + lst.size + rst.size;
        if(isBST) maxsize = Math.max(size,maxsize);
        return new find(max,min,size,isBST);
    }
}