package maximizescoreafternoperations

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class MaximizeScoreAfterNOperationsTest {
    @Test
    fun singlePair() {
        assertEquals(1, Solution().maxScore(intArrayOf(1, 2)))
    }

    @Test
    fun twoPairs() {
        assertEquals(11, Solution().maxScore(intArrayOf(3, 4, 6, 8)))
    }

    @Test
    fun threePairs() {
        assertEquals(14, Solution().maxScore(intArrayOf(1, 2, 3, 4, 5, 6)))
    }

    @Test
    fun duplicateValues() {
        assertEquals(15, Solution().maxScore(intArrayOf(5, 5, 5, 5)))
    }
}
