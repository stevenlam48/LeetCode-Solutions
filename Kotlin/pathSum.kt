package pathSum

import common.TreeNode

// Time Complexity: O(n)
// Space Complexity: O(logn)

class Solution {
    fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        pathSumImpl(root, sum, mutableListOf(), ans)
        return ans
    }

    private fun pathSumImpl(root: TreeNode?, sum: Int, v: MutableList<Int>, ans: MutableList<List<Int>>) {
        if (root == null) {
            return
        }

        v.add(root.`val`)

        if (root.left == null && root.right == null && root.`val` == sum) {
            ans.add(v.toList())
        }

        pathSumImpl(root.left, sum - root.`val`, v, ans)
        pathSumImpl(root.right, sum - root.`val`, v, ans)

        v.removeAt(v.size - 1)
    }
}
