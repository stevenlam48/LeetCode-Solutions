package maximumbinarytree

import common.TreeNode
import java.util.ArrayDeque

// Time:  O(n)
// Space: O(n)

class Solution {
    fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
        val nodeStack = ArrayDeque<TreeNode>()
        for (x in nums) {
            val node = TreeNode(x)
            while (nodeStack.isNotEmpty() && x > nodeStack.peekLast().`val`) {
                node.left = nodeStack.removeLast()
            }
            if (nodeStack.isNotEmpty()) {
                nodeStack.peekLast().right = node
            }
            nodeStack.addLast(node)
        }
        return nodeStack.peekFirst()
    }
}
