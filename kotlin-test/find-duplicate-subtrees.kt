package findduplicatesubtrees

import common.TreeNode
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindDuplicateSubtreesTest {
    private fun treeOf(vararg v: Int?): TreeNode? {
        if (v.isEmpty() || v[0] == null) {
            return null
        }
        val root = TreeNode(v[0]!!)
        val q = ArrayDeque<TreeNode>()
        q.addLast(root)
        var i = 1
        while (q.isNotEmpty() && i < v.size) {
            val node = q.removeFirst()
            if (i < v.size) {
                val l = v[i++]
                if (l != null) {
                    node.left = TreeNode(l)
                    q.addLast(node.left!!)
                }
            }
            if (i < v.size) {
                val r = v[i++]
                if (r != null) {
                    node.right = TreeNode(r)
                    q.addLast(node.right!!)
                }
            }
        }
        return root
    }

    private fun serialize(node: TreeNode?): String =
        if (node == null) "#" else "${node.`val`}(${serialize(node.left)},${serialize(node.right)})"

    @Test
    fun standardExample() {
        val root = treeOf(1, 2, 3, 4, null, 2, 4, null, null, 4)
        val actual = Solution().findDuplicateSubtrees(root).map { serialize(it) }.toSet()
        assertEquals(setOf("2(4(#,#),#)", "4(#,#)"), actual)
    }

    @Test
    fun twoIdenticalLeaves() {
        val root = treeOf(2, 1, 1)
        val actual = Solution().findDuplicateSubtrees(root).map { serialize(it) }.toSet()
        assertEquals(setOf("1(#,#)"), actual)
    }

    @Test
    fun nestedDuplicates() {
        val root = treeOf(2, 2, 2, 3, null, 3, null)
        val actual = Solution().findDuplicateSubtrees(root).map { serialize(it) }.toSet()
        assertEquals(setOf("3(#,#)", "2(3(#,#),#)"), actual)
    }

    @Test
    fun noDuplicates() {
        val root = treeOf(1, 2, 3)
        assertTrue(Solution().findDuplicateSubtrees(root).isEmpty())
    }
}
