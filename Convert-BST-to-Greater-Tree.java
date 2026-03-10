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
17    static int sum;
18    public TreeNode convertBST(TreeNode root) {
19        // ArrayList<TreeNode> list = new ArrayList<>();
20        // dfs(root,list);
21        // int sum = 0;
22        // for(int i=list.size()-1;i>=0;i--){
23        //     int x = list.get(i).val;
24        //     list.get(i).val = sum + x;
25        //    sum += x;
26        // }
27        // return root;
28        sum =0;
29        dfs(root);
30        return root;
31    }
32    // private void dfs(TreeNode root,ArrayList<TreeNode> list){
33    //     if(root == null) return;
34    //     dfs(root.left,list);
35    //     list.add(root);
36    //     dfs(root.right,list);
37    // }
38     private void dfs(TreeNode root){
39        if(root == null) return;
40        dfs(root.right);
41        int x = root.val;
42        root.val = sum + x;
43        sum += x;
44        dfs(root.left);
45    }
46}