package maximizescoreafterpairdeletions

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class MaximizeScoreAfterPairDeletionsTest {
    @Test
    fun evenLengthUsesMinimumAdjacentPair() {
        assertEquals(9, Solution().maxScore(intArrayOf(3, 4, 1, 6)))
    }

    @Test
    fun oddLengthUsesMinimumElement() {
        assertEquals(15, Solution().maxScore(intArrayOf(3, 4, 1, 6, 2)))
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().maxScore(intArrayOf(7)))
    }

    @Test
    fun handlesNegativeValues() {
        assertEquals(9, Solution().maxScore(intArrayOf(5, -1, 2, 4)))
    }
}
