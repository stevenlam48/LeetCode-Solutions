package stepbystepdirectionsfromabinarytreenodetoanother

import common.TreeNode

// Time:  O(n)
// Space: O(h)

class Solution {
    fun getDirections(root: TreeNode?, startValue: Int, destValue: Int): String {
        val src = StringBuilder(iterDfs(root, startValue))
        val dst = StringBuilder(iterDfs(root, destValue))
        while (src.length > 0 && dst.length > 0 && src[src.length - 1] == dst[dst.length - 1]) {
            src.deleteCharAt(src.length - 1)
            dst.deleteCharAt(dst.length - 1)
        }
        dst.reverse()
        return "U".repeat(src.length) + dst.toString()
    }

    private fun iterDfs(root: TreeNode?, value: Int): String {
        val path = StringBuilder()
        val stk = ArrayDeque<Triple<Int, TreeNode?, Char>>()
        stk.addLast(Triple(1, root, ' '))
        while (stk.isNotEmpty()) {
            val (step, node, d) = stk.removeLast()
            if (step == 1) {
                if (node!!.`val` == value) {
                    return path.reverse().toString()
                }
                for (child in listOf(node.left, node.right)) {
                    if (child == null) {
                        continue
                    }
                    stk.addLast(Triple(3, null, ' '))
                    stk.addLast(Triple(1, child, ' '))
                    stk.addLast(Triple(2, null, if (child === node.left) 'L' else 'R'))
                }
            } else if (step == 2) {
                path.append(d)
            } else if (step == 3) {
                path.deleteCharAt(path.length - 1)
            }
        }
        return ""
    }
}
