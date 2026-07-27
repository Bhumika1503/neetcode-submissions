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

class Solution {
    int preIndex = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return b(preorder, 0, inorder.length - 1);
    }

    private TreeNode b(int[] preorder, int left, int right)
     {

        if (left > right)
            return null;

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        int mid = map.get(rootVal);

        root.left = b(preorder, left, mid - 1);
        root.right = b(preorder, mid + 1, right);

        return root;
    }
}
