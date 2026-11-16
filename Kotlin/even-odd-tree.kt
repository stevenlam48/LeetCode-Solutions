package evenoddtree

import common.TreeNode

// Time:  O(n)
// Space: O(w)
class Solution {
    fun isEvenOddTree(root: TreeNode?): Boolean {
        var q = listOf(root)
        var isOdd = false
        while (q.isNotEmpty()) {
            val newQ = ArrayList<TreeNode?>()
            var prev: TreeNode? = null
            for (node in q) {
                val cur = node!!
                if (isOdd) {
                    if (cur.`val` % 2 != 0 || (prev != null && prev.`val` <= cur.`val`)) {
                        return false
                    }
                } else {
                    if (cur.`val` % 2 == 0 || (prev != null && prev.`val` >= cur.`val`)) {
                        return false
                    }
                }
                if (cur.left != null) {
                    newQ.add(cur.left)
                }
                if (cur.right != null) {
                    newQ.add(cur.right)
                }
                prev = cur
            }
            q = newQ
            isOdd = !isOdd
        }
        return true
    }
}
