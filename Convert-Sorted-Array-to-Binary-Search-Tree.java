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
17    public TreeNode sortedArrayToBST(int[] nums) {
18        int n = nums.length;
19        return convert(nums,0,n-1);
20    }
21    private TreeNode convert(int[] arr,int lo,int hi){
22        if(lo>hi) return null;
23        int mid = lo + (hi-lo)/2;
24        TreeNode root = new TreeNode(arr[mid]);
25        root.left = convert(arr,lo,mid-1);
26        root.right = convert(arr,mid+1,hi);
27        return root;
28    }
29}