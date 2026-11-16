package clonenarytree

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotSame
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CloneNAryTreeTest {
    @Test
    fun emptyTree() {
        assertNull(Solution().cloneTree(null))
    }

    @Test
    fun singleNode() {
        val root = Node(1)

        val copy = Solution().cloneTree(root)!!

        assertNotSame(root, copy)
        assertEquals(1, copy.`val`)
        assertTrue(copy.children.isEmpty())
    }

    @Test
    fun preservesChildOrderAndCopiesEveryNode() {
        val root = Node(1)
        val children = listOf(Node(2), Node(3), Node(4))
        root.children.addAll(children)

        val copy = Solution().cloneTree(root)!!

        assertEquals(listOf(2, 3, 4), copy.children.map { it!!.`val` })
        assertNotSame(root.children, copy.children)
        for (i in children.indices) {
            assertNotSame(children[i], copy.children[i])
        }
    }

    @Test
    fun clonesNestedChildren() {
        val root = Node(1)
        val child = Node(2)
        child.children.add(Node(3))
        child.children.add(Node(4))
        root.children.add(child)
        root.children.add(Node(5))

        val copy = Solution().cloneTree(root)!!

        assertEquals(2, copy.children.size)
        assertEquals(2, copy.children[0]!!.`val`)
        assertEquals(listOf(3, 4), copy.children[0]!!.children.map { it!!.`val` })
        assertEquals(5, copy.children[1]!!.`val`)
        assertNotSame(child, copy.children[0])
        assertNotSame(child.children[0], copy.children[0]!!.children[0])
        assertNotSame(child.children[1], copy.children[0]!!.children[1])
    }
}
