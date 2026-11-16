package binarytreecoloringgame

import common.TreeNode

// Time:  O(n)
// Space: O(h)
class Solution {
    fun btreeGameWinningMove(root: TreeNode?, n: Int, x: Int): Boolean {
        var leftRight = intArrayOf(0, 0)
        count(root, x) { leftRight = it }
        val (left, right) = leftRight
        val blue = maxOf(left, right, n - (left + right + 1))
        return blue > n - blue
    }

    private fun count(root: TreeNode?, x: Int, setLeftRight: (IntArray) -> Unit): Int {
        if (root == null) return 0
        val left = count(root.left, x, setLeftRight)
        val right = count(root.right, x, setLeftRight)
        if (root.`val` == x) {
            setLeftRight(intArrayOf(left, right))
        }
        return left + right + 1
    }
}
