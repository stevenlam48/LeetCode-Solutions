package cousinsinbinarytree

// Time:  O(n)
// Space: O(h)

import common.TreeNode

class Solution {
    fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
        val stateX = SearchState()
        val stateY = SearchState()
        return dfs(root, x, stateX) && dfs(root, y, stateY) &&
            stateX.depth == stateY.depth && stateX.parent !== stateY.parent
    }

    private fun dfs(root: TreeNode?, x: Int, state: SearchState): Boolean {
        if (root == null) {
            return false
        }
        if (root.`val` == x) {
            return true
        }
        ++state.depth
        val prevParent = state.parent
        state.parent = root
        if (dfs(root.left, x, state)) {
            return true
        }
        state.parent = root
        if (dfs(root.right, x, state)) {
            return true
        }
        state.parent = prevParent
        --state.depth
        return false
    }

    private data class SearchState(var depth: Int = 0, var parent: TreeNode? = null)
}
