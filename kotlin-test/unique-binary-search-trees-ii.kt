package uniquebinarysearchtreesii

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class UniqueBinarySearchTreesIiTest {
    private fun inorder(node: TreeNode?, out: MutableList<Int> = ArrayList()): List<Int> {
        if (node != null) {
            inorder(node.left, out)
            out.add(node.`val`)
            inorder(node.right, out)
        }
        return out
    }

    private fun preorder(node: TreeNode?, out: MutableList<Int> = ArrayList()): List<Int> {
        if (node != null) {
            out.add(node.`val`)
            preorder(node.left, out)
            preorder(node.right, out)
        }
        return out
    }

    @Test
    fun exampleN3() {
        val trees = Solution().generateTrees(3)
        assertEquals(5, trees.size)
        assertEquals(setOf(1, 2, 3), trees.map { it!!.`val` }.toSet())
        val shapes = trees.map { inorder(it) to preorder(it) }.toSet()
        assertEquals(5, shapes.size)
        for (t in trees) {
            assertEquals(listOf(1, 2, 3), inorder(t))
        }
    }

    @Test
    fun singleNode() {
        val trees = Solution().generateTrees(1)
        assertEquals(1, trees.size)
        assertEquals(1, trees[0]!!.`val`)
        assertTrue(trees[0]!!.left == null && trees[0]!!.right == null)
    }

    @Test
    fun zeroNodes() {
        assertEquals(emptyList<TreeNode?>(), Solution().generateTrees(0))
    }

    @Test
    fun exampleN2() {
        val trees = Solution().generateTrees(2)
        assertEquals(2, trees.size)
        assertEquals(listOf(1, 2), inorder(trees[0]))
        assertEquals(listOf(1, 2), inorder(trees[1]))
    }
}
