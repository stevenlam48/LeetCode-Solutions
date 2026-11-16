package pseudopalindromicpathsinabinarytree

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PseudoPalindromicPathsInABinaryTreeTest {
    private val solution = Solution()

    @Test
    fun validCase1() {
        val root = treeOf(2, 3, 1, 3, 1, null, 1)
        assertEquals(2, solution.pseudoPalindromicPaths(root))
    }

    @Test
    fun validCase2() {
        val root = treeOf(2, 1, 1, 1, 3, null, null, null, null, null, 1)
        assertEquals(1, solution.pseudoPalindromicPaths(root))
    }

    @Test
    fun validCase3_singleNode() {
        assertEquals(1, solution.pseudoPalindromicPaths(TreeNode(9)))
    }

    @Test
    fun validCase4_emptyTree() {
        assertEquals(0, solution.pseudoPalindromicPaths(null))
    }

    @Test
    fun validCase5_noPalindromicPaths() {
        val root = treeOf(1, 2, 3, 4, 5, 6, 7)
        assertEquals(0, solution.pseudoPalindromicPaths(root))
    }

    @Test
    fun validCase6_allPathsPseudoPalindromic() {
        val root = treeOf(1, 1, 1, 1, null, null, 1)
        assertEquals(2, solution.pseudoPalindromicPaths(root))
    }
}

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) {
        return null
    }
    val root = TreeNode(values[0]!!)
    val queue = ArrayDeque<TreeNode>()
    queue.add(root)
    var i = 1
    while (i < values.size && queue.isNotEmpty()) {
        val node = queue.removeFirst()
        if (i < values.size && values[i] != null) {
            node.left = TreeNode(values[i]!!)
            queue.add(node.left!!)
        }
        ++i
        if (i < values.size && values[i] != null) {
            node.right = TreeNode(values[i]!!)
            queue.add(node.right!!)
        }
        ++i
    }
    return root
}
