package leafsimilartrees
// Time:  O(n)
// Space: O(h)

import common.TreeNode

class Solution {
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        val s1 = mutableListOf(root1)
        val s2 = mutableListOf(root2)
        while (s1.isNotEmpty() && s2.isNotEmpty()) {
            if (dfs(s1) != dfs(s2)) {
                return false
            }
        }
        return s1.isEmpty() && s2.isEmpty()
    }

    private fun dfs(s: MutableList<TreeNode?>): Int {
        while (true) {
            val node = s.removeAt(s.lastIndex)!!
            val left = node.left
            val right = node.right
            if (right != null) {
                s.add(right)
            }
            if (left != null) {
                s.add(left)
            }
            if (left == null && right == null) {
                return node.`val`
            }
        }
    }
}
