package checkifdfsstringsarepalindromes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CheckIfDfsStringsArePalindromesTest {
    private val solution = Solution()

    @Test
    fun testTwoNodes() {
        assertEquals(listOf(false, true), solution.findAnswer(intArrayOf(-1, 0), "ab"))
    }

    @Test
    fun testThreeNodesPalindrome() {
        assertEquals(listOf(true, true, true), solution.findAnswer(intArrayOf(-1, 0, 0), "aaa"))
    }

    @Test
    fun testThreeNodesNotPalindrome() {
        assertEquals(listOf(false, true, true), solution.findAnswer(intArrayOf(-1, 0, 0), "abb"))
    }

    @Test
    fun testChain() {
        assertEquals(listOf(true, false, true), solution.findAnswer(intArrayOf(-1, 0, 1), "aba"))
    }

    @Test
    fun testMixedTree() {
        assertEquals(
            listOf(true, true, false, true, true, true),
            solution.findAnswer(intArrayOf(-1, 0, 0, 1, 1, 2), "aababa")
        )
    }
}
