package equaltreepartition

import common.TreeNode

// Time:  O(n)
// Space: O(n)
class Solution {
    fun checkEqualTree(root: TreeNode?): Boolean {
        val lookup = HashMap<Int, Int>()
        val total = getSumHelper(root, lookup)
        if (total == 0) {
            return (lookup[total] ?: 0) > 1
        }
        return total % 2 == 0 && lookup.containsKey(total / 2)
    }

    private fun getSumHelper(node: TreeNode?, lookup: HashMap<Int, Int>): Int {
        if (node == null) {
            return 0
        }
        val total = node.`val` +
            getSumHelper(node.left, lookup) +
            getSumHelper(node.right, lookup)
        lookup[total] = (lookup[total] ?: 0) + 1
        return total
    }
}
