package flipbinarytreetomatchpreordertraversal

import common.TreeNode

// Time:  O(n)
// Space: O(h)

class Solution {
    fun flipMatchVoyage(root: TreeNode?, voyage: IntArray): List<Int> {
        val result = mutableListOf<Int>()
        val i = intArrayOf(0)
        return if (dfs(root, voyage, i, result)) result else listOf(-1)
    }

    private fun dfs(root: TreeNode?, voyage: IntArray, i: IntArray, result: MutableList<Int>): Boolean {
        if (root == null) {
            return true
        }
        if (root.`val` != voyage[i[0]]) {
            return false
        }
        ++i[0]
        val left = root.left
        if (left != null && left.`val` != voyage[i[0]]) {
            result.add(root.`val`)
            return dfs(root.right, voyage, i, result) && dfs(left, voyage, i, result)
        }
        return dfs(left, voyage, i, result) && dfs(root.right, voyage, i, result)
    }
}
