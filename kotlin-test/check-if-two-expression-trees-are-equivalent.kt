package checkiftwoexpressiontreesareequivalent

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CheckIfTwoExpressionTreesAreEquivalentTest {
    private val solution = Solution()

    private fun leaf(value: Char): Node = Node(value)

    private fun node(value: Char, left: Node?, right: Node?): Node {
        val n = Node(value)
        n.left = left
        n.right = right
        return n
    }

    @Test
    fun testEquivalentAdditionOrder() {
        val root1 = node('+', leaf('a'), node('+', leaf('b'), leaf('c')))
        val root2 = node('+', node('+', leaf('a'), leaf('b')), leaf('c'))
        assertTrue(solution.checkEquivalence(root1, root2))
    }

    @Test
    fun testDifferentLetters() {
        val root1 = node('+', leaf('a'), leaf('b'))
        val root2 = node('+', leaf('a'), leaf('c'))
        assertFalse(solution.checkEquivalence(root1, root2))
    }

    @Test
    fun testSingleLeavesEqual() {
        assertTrue(solution.checkEquivalence(leaf('a'), leaf('a')))
    }

    @Test
    fun testSingleLeavesDifferent() {
        assertFalse(solution.checkEquivalence(leaf('a'), leaf('b')))
    }

    @Test
    fun testDuplicateLetters() {
        val root1 = node('+', leaf('a'), leaf('a'))
        val root2 = node('+', leaf('a'), leaf('b'))
        assertFalse(solution.checkEquivalence(root1, root2))
    }
}
