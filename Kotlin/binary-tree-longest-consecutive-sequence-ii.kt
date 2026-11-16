package binarytreelongestconsecutivesequenceii

import common.TreeNode

// Time:  O(n)
// Space: O(h)
class Solution {
    fun longestConsecutive(root: TreeNode?): Int {
        var maxLen = 0
        longestConsecutiveHelper(root) { maxLen = maxOf(maxLen, it) }
        return maxLen
    }

    private fun longestConsecutiveHelper(root: TreeNode?, updateMax: (Int) -> Unit): Pair<Int, Int> {
        if (root == null) return Pair(0, 0)
        val leftLen = longestConsecutiveHelper(root.left, updateMax)
        val rightLen = longestConsecutiveHelper(root.right, updateMax)
        var curIncLen = 1
        var curDecLen = 1
        root.left?.let {
            if (it.`val` == root.`val` + 1) {
                curIncLen = maxOf(curIncLen, leftLen.first + 1)
            } else if (it.`val` == root.`val` - 1) {
                curDecLen = maxOf(curDecLen, leftLen.second + 1)
            }
        }
        root.right?.let {
            if (it.`val` == root.`val` + 1) {
                curIncLen = maxOf(curIncLen, rightLen.first + 1)
            } else if (it.`val` == root.`val` - 1) {
                curDecLen = maxOf(curDecLen, rightLen.second + 1)
            }
        }
        updateMax(curDecLen + curIncLen - 1)
        return Pair(curIncLen, curDecLen)
    }
}
