package createbinarytreefromdescriptions

// Time:  O(n)
// Space: O(n)

import common.TreeNode

class Solution {
    fun createBinaryTree(descriptions: Array<IntArray>): TreeNode? {
        val nodes = HashMap<Int, TreeNode>()
        val children = HashSet<Int>()
        for (d in descriptions) {
            val parent = nodes.getOrPut(d[0]) { TreeNode(d[0]) }
            val child = nodes.getOrPut(d[1]) { TreeNode(d[1]) }
            if (d[2] != 0) {
                parent.left = child
            } else {
                parent.right = child
            }
            children.add(d[1])
        }
        for ((key, value) in nodes) {
            if (key !in children) {
                return value
            }
        }
        return null
    }
}
