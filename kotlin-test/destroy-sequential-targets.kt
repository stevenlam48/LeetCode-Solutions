package destroysequentialtargets

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DestroySequentialTargetsTest {
    private val solution = Solution()

    @Test
    fun testExample() {
        assertEquals(1, solution.destroyTargets(intArrayOf(3, 7, 8, 1, 1, 5), 2))
        assertEquals(1, solution.destroyTargets(intArrayOf(1, 3, 5, 2, 4, 6), 2))
        assertEquals(2, solution.destroyTargets(intArrayOf(6, 2, 5), 100))
    }

    @Test
    fun testSingleElement() {
        assertEquals(7, solution.destroyTargets(intArrayOf(7), 5))
        assertEquals(10, solution.destroyTargets(intArrayOf(10), 1))
    }

    @Test
    fun testAllSameRemainder() {
        assertEquals(2, solution.destroyTargets(intArrayOf(5, 2, 8, 11, 14), 3))
    }

    @Test
    fun testMaxCountTiePicksSmallestValue() {
        assertEquals(1, solution.destroyTargets(intArrayOf(1, 4, 2, 5), 3))
    }

    @Test
    fun testLargeValues() {
        assertEquals(
            7,
            solution.destroyTargets(intArrayOf(1000000000 - 1, 1000000000 - 3, 7), 2)
        )
    }
}
