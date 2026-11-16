package recoveratreefrompreordertraversal

import common.TreeNode

// Time:  O(n)
// Space: O(h)

class Solution {
    fun recoverFromPreorder(S: String): TreeNode? {
        var i = 0
        val stack = ArrayList<TreeNode>()
        while (i < S.length) {
            var j = i
            while (j < S.length && S[j] == '-') {
                ++j
            }
            val level = j - i
            i = j
            while (stack.size > level) {
                stack.removeAt(stack.size - 1)
            }
            j = i
            while (j < S.length && S[j] != '-') {
                ++j
            }
            val node = TreeNode(S.substring(i, j).toInt())
            i = j
            if (stack.isNotEmpty()) {
                if (stack.last().left == null) {
                    stack.last().left = node
                } else {
                    stack.last().right = node
                }
            }
            stack.add(node)
        }
        return stack.first()
    }
}
