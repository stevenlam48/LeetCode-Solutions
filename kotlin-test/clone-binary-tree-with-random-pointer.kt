package clonebinarytreewithrandompointer

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotSame
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test

class CloneBinaryTreeWithRandomPointerTest {
    @Test
    fun emptyTree() {
        assertNull(Solution().copyRandomBinaryTree(null))
    }

    @Test
    fun singleNodeWithSelfRandomPointer() {
        val root = Node(1)
        root.random = root

        val copy = Solution().copyRandomBinaryTree(root)!!

        assertNotSame(root, copy)
        assertEquals(1, copy.`val`)
        assertNull(copy.left)
        assertNull(copy.right)
        assertSame(copy, copy.random)
        assertSame(root, root.random)
    }

    @Test
    fun clonesChildrenAndRandomPointersAndRestoresInput() {
        val root = Node(1)
        val left = Node(2)
        val right = Node(3)
        root.left = left
        root.right = right
        root.random = left
        left.random = right
        right.random = root

        val copy = Solution().copyRandomBinaryTree(root)!!

        assertNotSame(root, copy)
        assertNotSame(left, copy.left)
        assertNotSame(right, copy.right)
        assertEquals(2, copy.left!!.`val`)
        assertEquals(3, copy.right!!.`val`)
        assertSame(copy.left, copy.random)
        assertSame(copy.right, copy.left!!.random)
        assertSame(copy, copy.right!!.random)
        assertSame(left, root.left)
        assertSame(right, root.right)
        assertSame(left, root.random)
        assertSame(right, left.random)
        assertSame(root, right.random)
    }

    @Test
    fun clonesDeeperTreeWithNullRandomPointers() {
        val root = Node(1)
        root.left = Node(2)
        root.left!!.left = Node(3)
        root.right = Node(4)

        val copy = Solution().copyRandomBinaryTree(root)!!

        assertEquals(3, copy.left!!.left!!.`val`)
        assertEquals(4, copy.right!!.`val`)
        assertNotSame(root.left!!.left, copy.left!!.left)
        assertNull(copy.random)
        assertNull(copy.left!!.random)
        assertNull(copy.right!!.random)
        assertNull(copy.left!!.left!!.left)
        assertNull(copy.left!!.left!!.right)
    }
}
