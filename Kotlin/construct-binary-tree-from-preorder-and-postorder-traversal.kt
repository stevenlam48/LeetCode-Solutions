package constructbinarytreefrompreorderandpostordertraversal

import common.TreeNode

// Time:  O(n)
// Space: O(h)

class Solution {
    fun constructFromPrePost(pre: IntArray, post: IntArray): TreeNode? {
        val s = ArrayDeque<TreeNode>()
        s.addLast(TreeNode(pre[0]))
        var j = 0
        for (i in 1 until pre.size) {
            val node = TreeNode(pre[i])
            while (s.last().`val` == post[j]) {
                s.removeLast()
                ++j
            }
            if (s.last().left == null) {
                s.last().left = node
            } else {
                s.last().right = node
            }
            s.addLast(node)
        }
        return s[0]
    }
}
