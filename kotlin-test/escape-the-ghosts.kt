package escapetheghosts

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EscapeTheGhostsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertFalse(solution.escapeGhosts(arrayOf(intArrayOf(1, 0)), intArrayOf(2, 0)))
    }

    @Test
    fun testExample2() {
        assertFalse(solution.escapeGhosts(arrayOf(intArrayOf(2, 0)), intArrayOf(1, 0)))
    }

    @Test
    fun testGhostFarAway() {
        assertTrue(solution.escapeGhosts(arrayOf(intArrayOf(5, 5)), intArrayOf(1, 1)))
        assertTrue(solution.escapeGhosts(arrayOf(intArrayOf(0, 1)), intArrayOf(1, 0)))
    }

    @Test
    fun testNoGhosts() {
        assertTrue(solution.escapeGhosts(arrayOf(), intArrayOf(3, 4)))
    }

    @Test
    fun testGhostAtTarget() {
        assertFalse(solution.escapeGhosts(arrayOf(intArrayOf(0, 0)), intArrayOf(0, 0)))
    }

    @Test
    fun testMultipleGhosts() {
        assertFalse(
            solution.escapeGhosts(
                arrayOf(intArrayOf(5, 5), intArrayOf(0, 0)),
                intArrayOf(1, 1)
            )
        )
    }
}
