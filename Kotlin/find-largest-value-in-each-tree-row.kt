package findlargestvalueineachtreerow
// Time:  O(n)
// Space: O(h)

import common.TreeNode

class Solution {
    fun largestValues(root: TreeNode?): IntArray {
        val result = mutableListOf<Int>()
        largestValuesHelper(root, 0, result)
        return result.toIntArray()
    }

    private fun largestValuesHelper(root: TreeNode?, depth: Int, result: MutableList<Int>) {
        if (root == null) {
            return
        }
        if (depth == result.size) {
            result.add(root.`val`)
        } else {
            result[depth] = maxOf(result[depth], root.`val`)
        }
        largestValuesHelper(root.left, depth + 1, result)
        largestValuesHelper(root.right, depth + 1, result)
    }
}
