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
17    public boolean isValidBST(TreeNode root) {
18        ArrayList<Integer> list = new ArrayList<>();
19        dfs(root,list);
20        for(int i=1;i<list.size();i++){
21            if(list.get(i) <= list.get(i-1)) return false;
22
23        }
24        return true;   
25    }
26    private void dfs(TreeNode root,ArrayList<Integer>list){
27        if(root == null) return;
28        dfs(root.left,list);
29        list.add(root.val);
30        dfs(root.right,list);
31    }
32}