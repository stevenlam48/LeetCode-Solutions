package findelementsinacontaminatedbinarytree

import common.TreeNode

// Time:  O(n)
// Space: O(h)

class FindElements(root: TreeNode?) {
    private val lookup = HashSet<Int>()

    init {
        dfs(root, 0)
    }

    fun find(target: Int): Boolean {
        return target in lookup
    }

    private fun dfs(node: TreeNode?, v: Int) {
        if (node == null) {
            return
        }
        node.`val` = v
        lookup.add(v)
        dfs(node.left, 2 * v + 1)
        dfs(node.right, 2 * v + 2)
    }
}
