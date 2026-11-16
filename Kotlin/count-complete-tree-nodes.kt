package countcompletetreenodes

// Time:  O(h * h) = O((logn)^2)
// Space: O(1)

import common.TreeNode

class Solution {
    fun countNodes(root: TreeNode?): Int {
        var count = 0
        var h = height(root)
        var node = root
        while (node != null) {
            if (height(node.right) == h - 1) {
                count += 1 shl h
                node = node.right
            } else {
                count += 1 shl (h - 1)
                node = node.left
            }
            --h
        }
        return count
    }

    private fun height(root: TreeNode?): Int {
        var h = -1
        var node = root
        while (node != null) {
            ++h
            node = node.left
        }
        return h
    }
}
