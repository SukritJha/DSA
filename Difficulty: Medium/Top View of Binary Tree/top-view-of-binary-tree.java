/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class pair{
    Node node;
    int distance;
    pair(Node node, int distance){
        this.node = node;
        this.distance = distance; // level or horizontal distance
    }
    
}
class Solution {
    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer>ans = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        Queue<pair>q = new LinkedList<>();
        q.add(new pair(root,0));
        int mindist = Integer.MAX_VALUE , maxdist = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            pair ele = q.remove();
            Node node = ele.node;
            int dist = ele.distance;
            mindist = Math.min(dist,mindist);
            maxdist = Math.max(dist,maxdist);
            if(!map.containsKey(dist)) map.put(dist,node.data);
            if(node.left !=null) q.add(new pair(node.left,dist-1));
            if(node.right != null) q.add(new pair(node.right,dist+1));
        }
        for(int i=mindist;i<=maxdist;i++){
            ans.add(map.get(i));
        }
        return ans;
    }
}