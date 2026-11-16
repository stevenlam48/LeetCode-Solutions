package changetherootofabinarytree

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test

class ChangeTheRootOfABinaryTreeTest {
    @Test
    fun flipRightLeaf() {
        val root = Node(1)
        val left = Node(2)
        val leaf = Node(3)
        root.left = left
        root.right = leaf
        left.parent = root
        leaf.parent = root

        val result = Solution().flipBinaryTree(root, leaf)
        assertSame(leaf, result)
        assertSame(root, leaf.left)
        assertNull(leaf.right)
        assertSame(left, root.left)
        assertNull(root.right)
        assertSame(leaf, root.parent)
    }

    @Test
    fun flipLeftLeaf() {
        val root = Node(1)
        val leaf = Node(2)
        val right = Node(3)
        root.left = leaf
        root.right = right
        leaf.parent = root
        right.parent = root

        assertSame(leaf, Solution().flipBinaryTree(root, leaf))
        assertSame(root, leaf.left)
        assertSame(right, root.right)
        assertNull(root.left)
        assertSame(leaf, root.parent)
    }

    @Test
    fun preserveOffPathSubtree() {
        val root = Node(1)
        val child = Node(2)
        val leaf = Node(3)
        val offPath = Node(4)
        root.left = child
        child.parent = root
        child.left = leaf
        child.right = offPath
        leaf.parent = child
        offPath.parent = child

        Solution().flipBinaryTree(root, leaf)
        assertSame(child, leaf.left)
        assertSame(root, child.left)
        assertSame(offPath, child.right)
        assertNull(root.left)
        assertNull(root.right)
    }

    @Test
    fun rootIsLeaf() {
        val root = Node(42)
        assertSame(root, Solution().flipBinaryTree(root, root))
        assertNull(root.left)
        assertNull(root.right)
        assertNull(root.parent)
    }
}
