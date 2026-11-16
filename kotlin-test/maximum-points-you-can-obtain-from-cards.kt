package maximumpointsyoucanobtainfromcards

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MaximumPointsYouCanObtainFromCardsTest {
    @Test
    fun firstExample() {
        assertEquals(12, Solution().maxScore(intArrayOf(1, 2, 3, 4, 5, 6, 1), 3))
    }

    @Test
    fun secondExample() {
        assertEquals(4, Solution().maxScore(intArrayOf(2, 2, 2), 2))
    }

    @Test
    fun thirdExample() {
        assertEquals(55, Solution().maxScore(intArrayOf(9, 7, 7, 9, 7, 7, 9), 7))
    }

    @Test
    fun singleCard() {
        assertEquals(8, Solution().maxScore(intArrayOf(8), 1))
    }
}
