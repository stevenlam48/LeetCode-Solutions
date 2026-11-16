package numberofgoodleafnodespairs

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

private fun treeOf(vararg v: Int?): TreeNode? {
    if (v.isEmpty() || v[0] == null) {
        return null
    }
    val root = TreeNode(v[0]!!)
    val queue = ArrayDeque<TreeNode>()
    queue.addLast(root)
    var i = 1
    while (queue.isNotEmpty() && i < v.size) {
        val node = queue.removeFirst()
        if (i < v.size) {
            val l = v[i++]
            if (l != null) {
                node.left = TreeNode(l)
                queue.addLast(node.left!!)
            }
        }
        if (i < v.size) {
            val r = v[i++]
            if (r != null) {
                node.right = TreeNode(r)
                queue.addLast(node.right!!)
            }
        }
    }
    return root
}

class NumberOfGoodLeafNodesPairsTest {
    @Test
    fun testExample1() {
        assertEquals(1, Solution().countPairs(treeOf(1, 2, 3, null, 4), 3))
    }

    @Test
    fun testExample2() {
        assertEquals(2, Solution().countPairs(treeOf(1, 2, 3, 4, 5, 6, 7), 3))
    }

    @Test
    fun testExample3() {
        assertEquals(
            1,
            Solution().countPairs(
                treeOf(7, 1, 4, 6, null, 5, 3, null, null, null, null, null, 2),
                3
            )
        )
    }

    @Test
    fun testDistanceTooSmall() {
        assertEquals(0, Solution().countPairs(treeOf(1, 2, 3), 1))
    }

    @Test
    fun testSingleNode() {
        assertEquals(0, Solution().countPairs(treeOf(1), 1))
    }
}
