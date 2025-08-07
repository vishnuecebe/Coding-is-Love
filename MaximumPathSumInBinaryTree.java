/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class MaximumPathSumInBinaryTree {
    // Function to return maximum path sum from any node in a tree.
    static int maxi;
    static int recursion(Node root){
        if(root==null){
            return 0;
        }
        int left = Math.max(0, recursion(root.left));
        int right = Math.max(0, recursion(root.right));
        maxi=Math.max(maxi,left+right+root.data);
        return root.data+Math.max(right,left);
    }
    int findMaxSum(Node node) {
        // your code goes here
        maxi=Integer.MIN_VALUE;
        recursion(node);
        return maxi;
    }
}
