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
16 // normal stack or recursion method se toh hum ye kr chuke hai ab morris traversal se kar rha hu
17 // remember!!!
18class Solution {
19    public List<Integer> inorderTraversal(TreeNode root) {
20        List<Integer> list = new ArrayList<>();
21        TreeNode curr = root;
22        while(curr!=null){
23            if(curr.left!=null){
24                TreeNode pred = curr.left;
25                while(pred.right !=null && pred.right!=curr){
26                    pred = pred.right;
27                }
28                 if(pred.right==null){
29                        pred.right = curr; // linking
30                        curr = curr.left;
31                    }
32                    else{
33                        pred.right = null; // unlinking
34                        list.add(curr.val);
35                        curr = curr.right;
36                    }
37            }
38            else{
39                list.add(curr.val);
40                curr = curr.right;
41            }
42        }
43        return list;
44    }  
45}