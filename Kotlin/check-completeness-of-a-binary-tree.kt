package checkcompletenessofabinarytree

import common.TreeNode

// Time:  O(n)
// Space: O(w)

class Solution {
    fun isCompleteTree(root: TreeNode?): Boolean {
        var end = false
        var current = mutableListOf<TreeNode?>(root)
        while (current.isNotEmpty()) {
            val nextLevel = mutableListOf<TreeNode?>()
            for (node in current) {
                if (node == null) {
                    end = true
                    continue
                }
                if (end) {
                    return false
                }
                nextLevel.add(node.left)
                nextLevel.add(node.right)
            }
            current = nextLevel
        }
        return true
    }
}
