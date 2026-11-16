package inordersuccessorinbstii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class InorderSuccessorInBstIiTest {
    @Test
    fun findsLeftmostNodeInRightSubtree() {
        val tree = tree()
        assertEquals(3, Solution().inorderSuccessor(tree[1])?.`val`)
    }

    @Test
    fun findsSuccessorAmongParents() {
        val tree = tree()
        assertEquals(2, Solution().inorderSuccessor(tree[0])?.`val`)
        assertEquals(7, Solution().inorderSuccessor(tree[2])?.`val`)
    }

    @Test
    fun handlesNullAndMaximum() {
        val tree = tree()
        assertNull(Solution().inorderSuccessor(null))
        assertNull(Solution().inorderSuccessor(tree[3]))
    }

    private fun tree(): List<Node> {
        val nodes = listOf(Node(1), Node(2), Node(4), Node(7), Node(3), Node(6))
        nodes[1].left = nodes[0]
        nodes[1].right = nodes[4]
        nodes[3].left = nodes[5]
        nodes[5].left = nodes[1]
        nodes[5].right = nodes[2]
        listOf(nodes[0], nodes[4]).forEach { it.parent = nodes[1] }
        nodes[1].parent = nodes[5]
        nodes[5].parent = nodes[3]
        nodes[2].parent = nodes[5]
        nodes[3].parent = null
        return nodes
    }
}
