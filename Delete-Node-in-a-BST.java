1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public TreeNode deleteNode(TreeNode root, int key) {
18        if(root==null) return null;
19        if(root.val>key){ // go left
20            root.left = deleteNode(root.left,key);
21        }
22        else if(root.val<key){ // go right
23            root.right = deleteNode(root.right,key);
24        }
25        else{ // root.val == key
26          if(root.left==null && root.right==null)  return null;
27          else if(root.left==null) return root.right; // single child case
28          else if(root.right==null) return root.left; // single child case
29          else{ // two child case
30        //   Pred method
31            // TreeNode pred = root.left;
32            //  while(pred.right !=null){
33            //   pred = pred.right;
34            //  }
35            // root.left = deleteNode(root.left,pred.val);
36            // pred.left = root.left;
37            // pred.right = root.right;
38            // return pred;
39            // succ method
40            TreeNode succ = root.right;
41            while(succ.left !=null){
42                succ = succ.left;
43            }
44            root.right = deleteNode(root.right,succ.val);
45            succ.left = root.left;
46            succ.right = root.right;
47            return succ;
48          }
49
50        }
51        return root;
52    }
53}