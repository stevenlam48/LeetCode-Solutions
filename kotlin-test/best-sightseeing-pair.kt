package bestsightseeingpair

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BestSightseeingPairTest {
    @Test
    fun example1() {
        assertEquals(11, Solution().maxScoreSightseeingPair(intArrayOf(8, 1, 5, 2, 6)))
    }

    @Test
    fun twoElements() {
        assertEquals(2, Solution().maxScoreSightseeingPair(intArrayOf(1, 2)))
    }

    @Test
    fun equalElements() {
        assertEquals(1, Solution().maxScoreSightseeingPair(intArrayOf(1, 1)))
    }

    @Test
    fun decreasing() {
        assertEquals(9, Solution().maxScoreSightseeingPair(intArrayOf(9, 1)))
    }
}
