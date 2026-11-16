package recoverbinarysearchtree

import common.TreeNode

// Time:  O(n)
// Space: O(1)

class Solution {
    fun recoverTree(root: TreeNode?) {
        morrisTraversal(root)
    }

    private fun morrisTraversal(root: TreeNode?) {
        if (root == null) {
            return
        }
        var brokenFirst: TreeNode? = null
        var brokenSecond: TreeNode? = null
        var prev: TreeNode? = null
        var cur: TreeNode? = root

        fun detect(prev: TreeNode?, cur: TreeNode) {
            if (prev != null && prev.`val` > cur.`val`) {
                if (brokenFirst == null) {
                    brokenFirst = prev
                }
                brokenSecond = cur
            }
        }

        while (cur != null) {
            if (cur.left == null) {
                detect(prev, cur)
                prev = cur
                cur = cur.right
            } else {
                var node: TreeNode? = cur.left
                while (node?.right != null && node.right !== cur) {
                    node = node.right
                }
                if (node?.right == null) {
                    node?.right = cur
                    cur = cur.left
                } else {
                    detect(prev, cur)
                    prev = cur
                    node.right = null
                    cur = cur.right
                }
            }
        }
        val first = brokenFirst!!
        val second = brokenSecond!!
        val tmp = first.`val`
        first.`val` = second.`val`
        second.`val` = tmp
    }
}
