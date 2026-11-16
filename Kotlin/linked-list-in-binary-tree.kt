package linkedlistinbinarytree

// Time:  O(n + l)
// Space: O(h + l)

import common.ListNode
import common.TreeNode

class Solution {
    fun isSubPath(head: ListNode?, root: TreeNode?): Boolean {
        if (head == null) {
            return true
        }
        val (pattern, prefix) = getPrefix(head)
        return dfs(pattern, prefix, root, -1)
    }

    private fun dfs(pattern: IntArray, prefix: IntArray, root: TreeNode?, start: Int): Boolean {
        if (root == null) {
            return false
        }
        var j = start
        while (j + 1 != 0 && pattern[j + 1] != root.`val`) {
            j = prefix[j]
        }
        if (pattern[j + 1] == root.`val`) {
            ++j
        }
        if (j + 1 == pattern.size) {
            return true
        }
        return dfs(pattern, prefix, root.left, j) ||
            dfs(pattern, prefix, root.right, j)
    }

    private fun getPrefix(head: ListNode): Pair<IntArray, IntArray> {
        val pattern = mutableListOf(head.`val`)
        val prefix = mutableListOf(-1)
        var j = -1
        var node = head.next
        while (node != null) {
            while (j + 1 != 0 && pattern[j + 1] != node.`val`) {
                j = prefix[j]
            }
            if (pattern[j + 1] == node.`val`) {
                ++j
            }
            pattern.add(node.`val`)
            prefix.add(j)
            node = node.next
        }
        return pattern.toIntArray() to prefix.toIntArray()
    }
}
