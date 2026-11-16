package constructbinarytreefromstring

import common.TreeNode

// Time:  O(n)
// Space: O(h)

class Solution {
    private var i = 0

    fun str2tree(s: String): TreeNode? {
        i = 0
        return if (s.isEmpty()) null else str2treeHelper(s)
    }

    private fun str2treeHelper(s: String): TreeNode? {
        val start = i
        if (s[i] == '-') {
            ++i
        }
        while (i < s.length && s[i].isDigit()) {
            ++i
        }

        val node = TreeNode(s.substring(start, i).toInt())
        if (i < s.length && s[i] == '(') {
            ++i
            node.left = str2treeHelper(s)
            ++i
        }
        if (i < s.length && s[i] == '(') {
            ++i
            node.right = str2treeHelper(s)
            ++i
        }
        return node
    }
}
