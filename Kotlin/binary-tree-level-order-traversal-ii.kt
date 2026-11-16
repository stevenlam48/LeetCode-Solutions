package binarytreelevelordertraversalii

import common.TreeNode
import java.util.ArrayDeque

// Time:  O(n)
// Space: O(n)
class Solution {
    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val queue = ArrayDeque<TreeNode>()
        if (root != null) queue.add(root)
        while (queue.isNotEmpty()) {
            val level = mutableListOf<Int>()
            val size = queue.size
            repeat(size) {
                val front = queue.removeFirst()
                level.add(front.`val`)
                front.left?.let { queue.add(it) }
                front.right?.let { queue.add(it) }
            }
            result.add(level)
        }
        result.reverse()
        return result
    }
}
