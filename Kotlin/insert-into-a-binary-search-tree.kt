package insertintoabinarysearchtree
// Time:  O(h)
// Space: O(1)

import common.TreeNode

class Solution {
    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
        var result = root
        var current = root
        var parent: TreeNode? = null
        while (current != null) {
            parent = current
            current = if (`val` <= current.`val`) current.left else current.right
        }
        if (parent == null) {
            result = TreeNode(`val`)
        } else if (`val` <= parent.`val`) {
            parent.left = TreeNode(`val`)
        } else {
            parent.right = TreeNode(`val`)
        }
        return result
    }
}
