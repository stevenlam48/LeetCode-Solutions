package zigzagLevelOrder

import common.TreeNode

// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val ans = ArrayList<MutableList<Int>>()
        if (root == null) {
            return ans
        }
        var isLeftToRight = true
        val q = ArrayDeque<TreeNode>()
        q.addLast(root)
        var size = 1
        var cnt = 0
        var v = ArrayList<Int>()
        while (size > 0) {
            val n = q.removeFirst()
            v.add(n.`val`)
            if (n.left != null) {
                q.addLast(n.left!!)
                cnt++
            }
            if (n.right != null) {
                q.addLast(n.right!!)
                cnt++
            }
            size--
            if (size == 0) {
                if (!isLeftToRight) {
                    v.reverse()
                }
                isLeftToRight = !isLeftToRight
                size = cnt
                cnt = 0
                ans.add(v)
                v = ArrayList()
            }
        }
        return ans
    }
}
