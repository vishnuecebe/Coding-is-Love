/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class Pair{
    TreeNode node;
    int number;
    Pair(TreeNode node,int number){
        this.node=node;
        this.number=number;
    }
 }
class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(root,0));
        int maxWidth= Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            int qsize=queue.size();
            int min=queue.peek().number;
            int max=Integer.MIN_VALUE;
            for(int index=0;index<qsize;index++){
                Pair curpair=queue.poll();
                TreeNode curNode=curpair.node;
                int index2=curpair.number-min;
                if(curNode.left!=null){
                    queue.add(new Pair(curNode.left,2*index2+1));
                }
                if(curNode.right!=null){
                    queue.add(new Pair(curNode.right,2*index2+2));
                }

                max=Math.max(max,curpair.number);
            }
            maxWidth=Math.max(maxWidth,max-min+1);
        }
        return maxWidth;
    }
}
