package lowestcommonancestorofabinarysearchtree

import common.TreeNode

// Time:  O(h)
// Space: O(1)

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode, q: TreeNode): TreeNode? {
        val s = minOf(p.`val`, q.`val`)
        val b = maxOf(p.`val`, q.`val`)

        var node = root
        while (node!!.`val` < s || node.`val` > b) {
            // Keep searching since root is outside of [s, b].
            node = if (s <= node.`val`) node.left else node.right
        }

        // s <= root.val && root.val <= b.
        return node
    }
}
