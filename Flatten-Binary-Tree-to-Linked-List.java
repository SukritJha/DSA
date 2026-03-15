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
17    public void flatten(TreeNode root) {
18        // M-2 Morris Traversal
19        TreeNode curr = root;
20        while(curr!=null){
21            if(curr.left!=null){
22                TreeNode pred = curr.left;
23                while(pred.right!=null&&pred.right!=curr){
24                    pred = pred.right;
25                }
26                pred.right = curr.right;
27                curr.right = curr.left;
28                curr.left = null;
29                curr = curr.right;
30            }
31            else{
32                curr = curr.right;
33            }
34        }    }
35    //     if(root == null) return;
36    //     ArrayList<TreeNode> arr = new ArrayList<>();
37    //     dfs(root,arr);
38    //     for(int i=0;i<arr.size()-1;i++){
39    //         TreeNode a = arr.get(i);
40    //         a.left = null;
41    //         a.right = arr.get(i+1);
42    //     }
43    //     // ye last element ke liye
44    //     TreeNode last = arr.get(arr.size()-1);
45    //     last.left = null;
46    //     last.right = null;
47    // }
48    // private void dfs(TreeNode root, ArrayList<TreeNode> arr){
49    //     if(root == null) return;
50    //     arr.add(root);
51    //     dfs(root.left,arr);
52    //     dfs(root.right,arr);
53    // }
54}