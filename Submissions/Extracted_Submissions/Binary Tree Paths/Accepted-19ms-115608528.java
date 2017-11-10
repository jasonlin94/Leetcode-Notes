// 
// Generated by fetch-leetcode-submission project on GitHub.
// https://github.com/gitzhou/fetch-leetcode-submission
// Contact Me: aaron67[AT]aaron67.cc
// 
// Binary Tree Paths
// https://leetcode.com/problems/binary-tree-paths/
// 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 第一个参数写错 helper(root.left, String.valueOf(root.val), result);
        helper(root, String.valueOf(root.val), result);
        return result;
    }
    private void helper(TreeNode root, String str, List<String> result) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            result.add(str);
        }
        if (root.left != null) {
            helper(root.left, str + "->" + String.valueOf(root.left.val), result);
        }
        if (root.right != null) {
            helper(root.right, str + "->" + String.valueOf(root.right.val), result);
        }
    }
}

