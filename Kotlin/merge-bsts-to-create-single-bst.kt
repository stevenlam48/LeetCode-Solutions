package mergebststocreatesinglebst
// Time:  O(n)
// Space: O(n)

import common.TreeNode

class Solution {
    fun canMerge(trees: List<TreeNode>): TreeNode? {
        val leafValsSet = mutableSetOf<Int>()
        val valToRoot = mutableMapOf<Int, TreeNode>()
        findLeavesAndRoots(trees, leafValsSet, valToRoot)
        val root = findRoot(trees, leafValsSet)
        return mergeBsts(root, leafValsSet, valToRoot)
    }

    private fun findLeavesAndRoots(
        trees: List<TreeNode>,
        leafValsSet: MutableSet<Int>,
        valToRoot: MutableMap<Int, TreeNode>
    ) {
        for (root in trees) {
            valToRoot[root.`val`] = root
            var q = listOf(root)
            while (q.isNotEmpty()) {
                val newQ = mutableListOf<TreeNode>()
                for (node in q) {
                    if (node.left == null && node.right == null) {
                        if (node !== root) {
                            leafValsSet.add(node.`val`)
                        }
                        continue
                    }
                    node.left?.let(newQ::add)
                    node.right?.let(newQ::add)
                }
                q = newQ
            }
        }
    }

    private fun findRoot(trees: List<TreeNode>, leafValsSet: Set<Int>): TreeNode? {
        var root: TreeNode? = null
        for (node in trees) {
            if (node.`val` in leafValsSet) {
                continue
            }
            if (root != null) {
                return null
            }
            root = node
        }
        return root
    }

    private fun mergeBsts(
        root: TreeNode?,
        leafValsSet: Set<Int>,
        valToRoot: MutableMap<Int, TreeNode>
    ): TreeNode? {
        if (root == null) {
            return null
        }
        valToRoot.remove(root.`val`)
        var q = listOf(Triple(root, Int.MIN_VALUE, Int.MAX_VALUE))
        while (q.isNotEmpty()) {
            val newQ = mutableListOf<Triple<TreeNode, Int, Int>>()
            for ((node, left, right) in q) {
                if (!(left < node.`val` && node.`val` < right)) {
                    return null
                }
                if (node.left != null) {
                    if (node.left!!.`val` in leafValsSet && valToRoot.containsKey(node.left!!.`val`)) {
                        node.left = valToRoot.getValue(node.left!!.`val`)
                        valToRoot.remove(node.left!!.`val`)
                    }
                    newQ.add(Triple(node.left!!, left, node.`val`))
                }
                if (node.right != null) {
                    if (node.right!!.`val` in leafValsSet && valToRoot.containsKey(node.right!!.`val`)) {
                        node.right = valToRoot.getValue(node.right!!.`val`)
                        valToRoot.remove(node.right!!.`val`)
                    }
                    newQ.add(Triple(node.right!!, node.`val`, right))
                }
            }
            q = newQ
        }
        return if (valToRoot.isEmpty()) root else null
    }
}
