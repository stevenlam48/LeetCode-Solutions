package findmodeinbinarysearchtree

// Time:  O(n)
// Space: O(h)

import common.TreeNode

class Solution {
    fun findMode(root: TreeNode?): IntArray {
        if (root == null) {
            return intArrayOf()
        }
        val result = mutableListOf<Int>()
        var prev: TreeNode? = null
        var cnt = 1
        var maxCnt = 0

        fun inorder(node: TreeNode?) {
            if (node == null) {
                return
            }
            inorder(node.left)
            if (prev != null) {
                if (node.`val` == prev!!.`val`) {
                    ++cnt
                } else {
                    cnt = 1
                }
            }
            if (cnt > maxCnt) {
                maxCnt = cnt
                result.clear()
                result.add(node.`val`)
            } else if (cnt == maxCnt) {
                result.add(node.`val`)
            }
            prev = node
            inorder(node.right)
        }

        inorder(root)
        return result.toIntArray()
    }
}
