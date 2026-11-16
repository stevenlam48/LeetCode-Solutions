package minimumtimetoactivatestring

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumTimeToActivateStringTest {
    private val solution = Solution()

    @Test
    fun testStandardExample() {
        assertEquals(0, solution.minTime("abca", intArrayOf(0, 1, 2, 3), 4))
        assertEquals(1, solution.minTime("abca", intArrayOf(0, 1, 2, 3), 7))
        assertEquals(3, solution.minTime("abca", intArrayOf(0, 1, 2, 3), 10))
    }

    @Test
    fun testImpossible() {
        assertEquals(-1, solution.minTime("abca", intArrayOf(0, 1, 2, 3), 11))
    }

    @Test
    fun testNonSequentialOrder() {
        assertEquals(0, solution.minTime("abc", intArrayOf(2, 0, 1), 3))
        assertEquals(1, solution.minTime("abcde", intArrayOf(3, 1, 0, 4, 2), 10))
    }

    @Test
    fun testSingleCharacter() {
        assertEquals(0, solution.minTime("a", intArrayOf(0), 1))
        assertEquals(-1, solution.minTime("a", intArrayOf(0), 2))
    }
}
