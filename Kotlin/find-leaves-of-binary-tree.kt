package findleavesofbinarytree
// Time:  O(n)
// Space: O(h)

import common.TreeNode

class Solution {
    fun findLeaves(root: TreeNode?): Array<IntArray> {
        val result = mutableListOf<MutableList<Int>>()
        findLeavesHelper(root, result)
        return result.map { it.toIntArray() }.toTypedArray()
    }

    private fun findLeavesHelper(node: TreeNode?, result: MutableList<MutableList<Int>>): Int {
        if (node == null) {
            return -1
        }
        val level = 1 + maxOf(
            findLeavesHelper(node.left, result),
            findLeavesHelper(node.right, result)
        )
        if (result.size < level + 1) {
            result.add(mutableListOf())
        }
        result[level].add(node.`val`)
        return level
    }
}
