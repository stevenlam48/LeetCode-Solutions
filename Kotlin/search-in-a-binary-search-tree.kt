package searchinabinarysearchtree

// Time:  O(h)
// Space: O(1)

import common.TreeNode

class Solution {
    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        var node = root
        while (node != null && `val` != node.`val`) {
            node = if (`val` < node.`val`) node.left else node.right
        }
        return node
    }
}
