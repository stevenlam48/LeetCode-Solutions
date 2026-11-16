package pathsumiii

// Time:  O(n)
// Space: O(h)

import common.TreeNode

class Solution {
    fun pathSum(root: TreeNode?, sum: Int): Int {
        val lookup = HashMap<Int, Int>()
        lookup[0] = 1
        return pathSumHelper(root, 0, sum, lookup)
    }

    private fun pathSumHelper(
        root: TreeNode?,
        current: Int,
        sum: Int,
        lookup: HashMap<Int, Int>
    ): Int {
        if (root == null) {
            return 0
        }
        val curr = current + root.`val`
        var result = lookup[curr - sum] ?: 0
        lookup[curr] = (lookup[curr] ?: 0) + 1
        result += pathSumHelper(root.left, curr, sum, lookup) +
            pathSumHelper(root.right, curr, sum, lookup)
        lookup[curr] = lookup.getValue(curr) - 1
        if (lookup[curr] == 0) {
            lookup.remove(curr)
        }
        return result
    }
}
