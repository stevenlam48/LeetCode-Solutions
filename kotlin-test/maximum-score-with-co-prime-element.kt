package maximumscorewithcoprimeelement

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumScoreWithCoPrimeElementTest {
    @Test
    fun singleOne() {
        assertEquals(1, Solution().maxScore(intArrayOf(1), 1))
    }

    @Test
    fun twoPrimes() {
        assertEquals(3, Solution().maxScore(intArrayOf(2, 3), 3))
    }

    @Test
    fun sharedFactor() {
        assertEquals(3, Solution().maxScore(intArrayOf(2, 4), 4))
    }

    @Test
    fun mixedValues() {
        assertEquals(3, Solution().maxScore(intArrayOf(1, 2, 3, 4), 4))
    }

    @Test
    fun duplicates() {
        assertEquals(3, Solution().maxScore(intArrayOf(5, 5, 5), 5))
    }
}
