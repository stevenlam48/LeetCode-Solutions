package numberofpairssatisfyinginequality

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfPairsSatisfyingInequalityTest {
    private val solution = Solution()

    @Test
    fun `counts all pairs satisfying the example inequality`() {
        assertEquals(
            3L,
            solution.numberOfPairs(intArrayOf(3, 2, 5), intArrayOf(2, 2, 1), 1)
        )
    }

    @Test
    fun `returns zero when no pair satisfies the inequality`() {
        assertEquals(
            0L,
            solution.numberOfPairs(intArrayOf(3, -1), intArrayOf(-2, 2), -1)
        )
    }

    @Test
    fun `handles duplicates and a tight difference bound`() {
        assertEquals(
            3L,
            solution.numberOfPairs(intArrayOf(1, 1, 1), intArrayOf(1, 1, 1), 0)
        )
    }

    @Test
    fun `supports negative bounds and increasing values`() {
        assertEquals(
            6L,
            solution.numberOfPairs(
                intArrayOf(1, 2, 3, 4, 5),
                intArrayOf(0, 0, 0, 0, 0),
                -2
            )
        )
    }

    @Test
    fun `handles empty and single element inputs`() {
        assertEquals(0L, solution.numberOfPairs(intArrayOf(), intArrayOf(), 0))
        assertEquals(0L, solution.numberOfPairs(intArrayOf(2), intArrayOf(5), 10))
    }
}
