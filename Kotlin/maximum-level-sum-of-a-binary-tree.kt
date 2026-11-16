package maximumlevelsumofabinarytree

// Time:  O(n)
// Space: O(h)

import common.TreeNode

class Solution {
    fun maxLevelSum(root: TreeNode?): Int {
        val levelSums = mutableListOf<Int>()
        dfs(root, 0, levelSums)
        var best = 0
        for (i in 1 until levelSums.size) {
            if (levelSums[i] > levelSums[best]) {
                best = i
            }
        }
        return best + 1
    }

    private fun dfs(node: TreeNode?, level: Int, levelSums: MutableList<Int>) {
        if (node == null) {
            return
        }
        if (level == levelSums.size) {
            levelSums.add(0)
        }
        levelSums[level] += node.`val`
        dfs(node.left, level + 1, levelSums)
        dfs(node.right, level + 1, levelSums)
    }
}
