package com.gyadav.practice.lc;

import com.gyadav.practice.helper.TreeNode;

/*Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

        For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

          1
         / \
         2   2
        / \ / \
       3  4 4  3


        But the following [1,2,2,null,3,null,3] is not:

         1
        / \
       2   2
        \   \
        3    3*/
public class SymmetricTree101 {
    public static void main(String[] args){
        TreeNode treeNode = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        treeNode.left = left;
        TreeNode right = new TreeNode(2);
        treeNode.right = right;
        left.left = new TreeNode(3);
        left.right = new TreeNode(4);
        right.left = new TreeNode(4);
        right.right = new TreeNode(3);
        SymmetricTree101 symmetricTree101 = new SymmetricTree101();
        symmetricTree101.isSymmetric(treeNode);

    }
    public boolean isSymmetric(TreeNode root) {
        return false;
    }
    public boolean checkNodes (TreeNode left, TreeNode right){
        if(left.val !=right.val ){
            return false;
        }
        return false;
    }
}
