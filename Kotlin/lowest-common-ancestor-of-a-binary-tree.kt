package lowestcommonancestorofabinarytree

import common.TreeNode

// Time:  O(n)
// Space: O(h)

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode, q: TreeNode): TreeNode? {
        if (root == null || root === p || root === q) {
            return root
        }
        val left = lowestCommonAncestor(root.left, p, q)
        val right = lowestCommonAncestor(root.right, p, q)
        // 1. If the current subtree contains both p and q,
        //    return their LCA.
        // 2. If only one of them is in that subtree,
        //    return that one of them.
        // 3. If neither of them is in that subtree,
        //    return the node of that subtree.
        return if (left != null) (if (right != null) root else left) else right
    }
}
