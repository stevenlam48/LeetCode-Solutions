package uniquebinarysearchtreesii

import common.TreeNode

// Time:  O(n * 4^n / n^(3/2)) ~= Catalan numbers
// Space: O(n)

class Solution {
    fun generateTrees(n: Int): List<TreeNode?> {
        if (n == 0) {
            return emptyList()
        }
        return generateTreesHelper(1, n)
    }

    private fun generateTreesHelper(start: Int, end: Int): List<TreeNode?> {
        val result = ArrayList<TreeNode?>()
        if (start > end) {
            result.add(null)
            return result
        }

        for (i in start..end) {
            val leftSubTrees = generateTreesHelper(start, i - 1)
            val rightSubTrees = generateTreesHelper(i + 1, end)
            for (left in leftSubTrees) {
                for (right in rightSubTrees) {
                    val root = TreeNode(i)
                    root.left = clone(left)
                    root.right = clone(right)
                    result.add(root)
                }
            }
        }
        return result
    }

    private fun clone(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }
        val newRoot = TreeNode(root.`val`)
        newRoot.left = clone(root.left)
        newRoot.right = clone(root.right)
        return newRoot
    }
}
