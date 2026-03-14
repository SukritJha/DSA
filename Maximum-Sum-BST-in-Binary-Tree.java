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
16class finder{
17    int max;
18    int min;
19    int sum;
20    boolean isBST;
21    finder(int max,int min,int sum,boolean isBST){
22        this.max = max;
23        this.min = min;
24        this.sum = sum;
25        this.isBST = isBST;
26    }
27}
28class Solution {
29    static int maxsum;
30    public int maxSumBST(TreeNode root) {
31        maxsum =0;
32        helper(root);
33        return maxsum;
34    }
35    private finder helper(TreeNode root){
36        if(root ==null) return new finder(Integer.MIN_VALUE,Integer.MAX_VALUE,0,true);
37        finder lst = helper(root.left);
38        finder rst = helper(root.right);
39        int max = Math.max(root.val,Math.max(lst.max,rst.max));
40        int min = Math.min(root.val,Math.min(lst.min,rst.min));
41        int sum = root.val + lst.sum + rst.sum;
42        boolean isBST = root.val>lst.max && root.val<rst.min && lst.isBST && rst.isBST;
43        if(isBST) maxsum = Math.max(sum,maxsum);
44        return new finder(max,min,sum,isBST);
45    }
46}