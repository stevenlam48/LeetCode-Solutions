package binarytreelongestconsecutivesequence

import common.TreeNode

// Time:  O(n)
// Space: O(h)
class Solution {
    fun longestConsecutive(root: TreeNode?): Int {
        var maxLen = 0
        longestConsecutiveHelper(root) { maxLen = maxOf(maxLen, it) }
        return maxLen
    }

    private fun longestConsecutiveHelper(root: TreeNode?, updateMax: (Int) -> Unit): Int {
        if (root == null) return 0
        val leftLen = longestConsecutiveHelper(root.left, updateMax)
        val rightLen = longestConsecutiveHelper(root.right, updateMax)
        var curLen = 1
        if (root.left != null && root.left!!.`val` == root.`val` + 1) {
            curLen = maxOf(curLen, leftLen + 1)
        }
        if (root.right != null && root.right!!.`val` == root.`val` + 1) {
            curLen = maxOf(curLen, rightLen + 1)
        }
        updateMax(maxOf(curLen, leftLen, rightLen))
        return curLen
    }
}
