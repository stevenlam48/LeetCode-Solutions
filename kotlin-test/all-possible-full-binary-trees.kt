package allpossiblefullbinarytrees

import common.TreeNode
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AllPossibleFullBinaryTreesTest {
    private fun countAndCheck(node: TreeNode?): Int {
        if (node == null) {
            return 0
        }
        val l = node.left
        val r = node.right
        assertTrue((l == null) == (r == null), "node must have either zero or two children")
        return 1 + countAndCheck(l) + countAndCheck(r)
    }

    private fun serialize(node: TreeNode?): String {
        if (node == null) {
            return "#"
        }
        return "${node.`val`},${serialize(node.left)},${serialize(node.right)}"
    }

    @Test
    fun testOneNode() {
        val trees = Solution().allPossibleFBT(1)
        assertEquals(1, trees.size)
        assertEquals(1, countAndCheck(trees[0]))
    }

    @Test
    fun testThreeNodes() {
        val trees = Solution().allPossibleFBT(3)
        assertEquals(1, trees.size)
        assertEquals(1, trees.map { serialize(it) }.toSet().size)
        assertTrue(trees.all { countAndCheck(it) == 3 })
    }

    @Test
    fun testFiveNodes() {
        val trees = Solution().allPossibleFBT(5)
        assertEquals(2, trees.size)
        assertEquals(2, trees.map { serialize(it) }.toSet().size)
        assertTrue(trees.all { countAndCheck(it) == 5 })
    }

    @Test
    fun testSevenNodes() {
        val trees = Solution().allPossibleFBT(7)
        assertEquals(5, trees.size)
        assertEquals(5, trees.map { serialize(it) }.toSet().size)
        assertTrue(trees.all { countAndCheck(it) == 7 })
    }

    @Test
    fun testEvenIsEmpty() {
        assertEquals(0, Solution().allPossibleFBT(0).size)
        assertEquals(0, Solution().allPossibleFBT(2).size)
        assertEquals(0, Solution().allPossibleFBT(4).size)
    }
}
