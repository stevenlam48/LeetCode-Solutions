package checkifthereisavalidparenthesesstringpath

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CheckIfThereIsAValidParenthesesStringPathTest {
    private val solution = Solution()

    @Test
    fun testValidPath() {
        val grid = arrayOf(
            charArrayOf('(', '(', '('),
            charArrayOf('(', ')', ')')
        )
        assertTrue(solution.hasValidPath(grid))
    }

    @Test
    fun testInvalidPath() {
        val grid = arrayOf(
            charArrayOf('(', '(', '('),
            charArrayOf('(', '(', ')')
        )
        assertFalse(solution.hasValidPath(grid))
    }

    @Test
    fun testSingleRowValid() {
        assertTrue(solution.hasValidPath(arrayOf(charArrayOf('(', ')'))))
    }

    @Test
    fun testSingleRowInvalid() {
        assertFalse(solution.hasValidPath(arrayOf(charArrayOf(')', '('))))
    }

    @Test
    fun testOddNumberOfCells() {
        val grid = arrayOf(
            charArrayOf('(', '('),
            charArrayOf('(', '(')
        )
        assertFalse(solution.hasValidPath(grid))
    }

    @Test
    fun testAllClosing() {
        val grid = arrayOf(
            charArrayOf(')', ')'),
            charArrayOf(')', ')')
        )
        assertFalse(solution.hasValidPath(grid))
    }
}
