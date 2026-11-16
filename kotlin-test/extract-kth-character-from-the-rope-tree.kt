package extractkthcharacterfromtheropetree

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ExtractKthCharacterFromTheRopeTreeTest {
    private val solution = Solution()

    @Test
    fun `reads directly from a leaf`() {
        assertEquals('b', solution.getKthCharacter(leaf("abc"), 2))
    }

    @Test
    fun `traverses from left subtree into right subtree`() {
        val root = rope(leaf("abc"), leaf("def"))
        assertEquals('a', solution.getKthCharacter(root, 1))
        assertEquals('d', solution.getKthCharacter(root, 4))
        assertEquals('f', solution.getKthCharacter(root, 6))
    }

    @Test
    fun `uses an internal left subtree length`() {
        val root = rope(rope(leaf("ab"), leaf("cde")), leaf("fgh"))
        assertEquals('c', solution.getKthCharacter(root, 3))
        assertEquals('e', solution.getKthCharacter(root, 5))
        assertEquals('f', solution.getKthCharacter(root, 6))
        assertEquals('h', solution.getKthCharacter(root, 8))
    }

    @Test
    fun `handles leaves on only one side at each level`() {
        val root = rope(leaf("a"), rope(leaf("bc"), leaf("d")))
        assertEquals('a', solution.getKthCharacter(root, 1))
        assertEquals('c', solution.getKthCharacter(root, 3))
        assertEquals('d', solution.getKthCharacter(root, 4))
    }
}

private fun leaf(value: String): RopeTreeNode {
    return RopeTreeNode(0, value)
}

private fun rope(left: RopeTreeNode, right: RopeTreeNode): RopeTreeNode {
    val root = RopeTreeNode(length(left) + length(right))
    root.left = left
    root.right = right
    return root
}

private fun length(node: RopeTreeNode): Int {
    return maxOf(node.len, node.`val`.length)
}
