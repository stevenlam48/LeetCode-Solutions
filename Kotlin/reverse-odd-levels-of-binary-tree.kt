package reverseoddlevelsofbinarytree
// Time:  O(n)
// Space: O(n)

import common.TreeNode

class Solution {
    fun reverseOddLevels(root: TreeNode?): TreeNode? {
        if (root == null) return null
        var queue = mutableListOf(root)
        var parity = 0
        while (queue.isNotEmpty()) {
            if (parity != 0) {
                var left = 0
                var right = queue.size - 1
                while (left < right) {
                    val value = queue[left].`val`
                    queue[left].`val` = queue[right].`val`
                    queue[right].`val` = value
                    ++left
                    --right
                }
            }
            if (queue[0].left == null) break
            val next = mutableListOf<TreeNode>()
            for (node in queue) {
                next.add(node.left!!)
                next.add(node.right!!)
            }
            queue = next
            parity = parity xor 1
        }
        return root
    }
}
