package Lec15;

public class Delete_Node_in_a_BST {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if(root==null){
                return null;
            }
            if(key>root.val){
                root.right=deleteNode(root.right,key);
            }
            else if(key<root.val){
                root.left=deleteNode(root.left,key);
            }
            else{
                if(root.right==null){
                    return root.left;
                }
                else if(root.left==null){
                    return root.right;
                }
                else{
                    int min=Min(root.right);
                    root.right=deleteNode(root.right,min);
                    root.val=min;
                }
            }
            return root;
        }
        public int Min(TreeNode root){
            if(root==null){
                return Integer.MAX_VALUE;
            }
            int l=Min(root.left);
            return Math.min(l,root.val);
        }
    }
}
