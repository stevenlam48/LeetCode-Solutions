package maximizetheminimumgamescore

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeTheMinimumGameScoreTest {
    @Test
    fun exampleOne() {
        assertEquals(4L, Solution().maxScore(intArrayOf(2, 4), 3))
    }

    @Test
    fun exampleTwo() {
        assertEquals(2L, Solution().maxScore(intArrayOf(1, 2, 3), 5))
    }

    @Test
    fun singlePoint() {
        assertEquals(1L, Solution().maxScore(intArrayOf(1), 1))
    }

    @Test
    fun equalPoints() {
        assertEquals(5L, Solution().maxScore(intArrayOf(5, 5, 5), 5))
    }
}
