package constructquadtree

// Time:  O(n)
// Space: O(h)

class Node(
    var `val`: Boolean,
    var isLeaf: Boolean,
    var topLeft: Node? = null,
    var topRight: Node? = null,
    var bottomLeft: Node? = null,
    var bottomRight: Node? = null
)

class Solution {
    fun construct(grid: Array<IntArray>): Node? {
        if (grid.isEmpty()) {
            return null
        }
        return dfs(grid, 0, 0, grid.size)
    }

    private fun dfs(grid: Array<IntArray>, x: Int, y: Int, l: Int): Node {
        if (l == 1) {
            return Node(grid[x][y] == 1, true)
        }
        val half = l / 2
        val topLeftNode = dfs(grid, x, y, half)
        val topRightNode = dfs(grid, x, y + half, half)
        val bottomLeftNode = dfs(grid, x + half, y, half)
        val bottomRightNode = dfs(grid, x + half, y + half, half)
        if (topLeftNode.isLeaf && topRightNode.isLeaf &&
            bottomLeftNode.isLeaf && bottomRightNode.isLeaf &&
            topLeftNode.`val` == topRightNode.`val` &&
            topRightNode.`val` == bottomLeftNode.`val` &&
            bottomLeftNode.`val` == bottomRightNode.`val`
        ) {
            return Node(topLeftNode.`val`, true)
        }
        return Node(true, false, topLeftNode, topRightNode, bottomLeftNode, bottomRightNode)
    }
}
