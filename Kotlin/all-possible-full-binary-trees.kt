package allpossiblefullbinarytrees

import common.TreeNode

// Time:  O(n * 4^n / n^(3/2)) ~= sum of Catalan numbers from 1 .. N
// Space: O(n * 4^n / n^(3/2)) ~= sum of Catalan numbers from 1 .. N

class Solution {
    private val memo = HashMap<Int, List<TreeNode>>()

    fun allPossibleFBT(N: Int): List<TreeNode> {
        memo[N]?.let { return it }
        val result = mutableListOf<TreeNode>()
        when {
            N == 1 -> result.add(TreeNode(0))
            N % 2 == 1 -> {
                for (i in 0 until N) {
                    for (left in allPossibleFBT(i)) {
                        for (right in allPossibleFBT(N - 1 - i)) {
                            val node = TreeNode(0)
                            node.left = left
                            node.right = right
                            result.add(node)
                        }
                    }
                }
            }
        }
        memo[N] = result
        return result
    }
}
