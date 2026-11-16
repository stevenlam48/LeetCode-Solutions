package addonerowtotree

import common.TreeNode

// Time:  O(n)
// Space: O(h)

class Solution {
    fun addOneRow(root: TreeNode?, v: Int, d: Int): TreeNode? {
        if (d == 0 || d == 1) {
            val node = TreeNode(v)
            if (d == 1) {
                node.left = root
            } else {
                node.right = root
            }
            return node
        }
        if (root != null && d >= 2) {
            root.left = addOneRow(root.left, v, if (d > 2) d - 1 else 1)
            root.right = addOneRow(root.right, v, if (d > 2) d - 1 else 0)
        }
        return root
    }
}
