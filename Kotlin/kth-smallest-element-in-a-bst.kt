package kthsmallestelementinabst

import common.TreeNode
import java.util.ArrayDeque

// Time:  O(max(h, k))
// Space: O(min(h, k))

class Solution {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val s = ArrayDeque<TreeNode>()
        var cur = root
        var rank = 0
        while (s.isNotEmpty() || cur != null) {
            if (cur != null) {
                s.addLast(cur)
                if (s.size > k) {
                    s.removeFirst()
                }
                cur = cur.left
            } else {
                val node = s.removeLast()
                cur = node
                ++rank
                if (rank == k) {
                    return node.`val`
                }
                cur = node.right
            }
        }
        return Int.MIN_VALUE
    }
}
