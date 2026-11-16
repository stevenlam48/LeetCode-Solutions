package probabilityofatwoboxeshavingthesamenumberofdistinctballs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ProbabilityOfATwoBoxesHavingTheSameNumberOfDistinctBallsTest {
    private val solution = Solution()
    private val epsilon = 1e-9

    @Test
    fun validCase1() {
        val actual = solution.getProbability(intArrayOf(1, 1))
        assertEquals(1.0, actual, epsilon)
    }

    @Test
    fun validCase2() {
        val actual = solution.getProbability(intArrayOf(2, 1, 1))
        assertEquals(0.6666666666666666, actual, epsilon)
    }

    @Test
    fun validCase3() {
        val actual = solution.getProbability(intArrayOf(1, 2, 1, 2))
        assertEquals(0.6, actual, epsilon)
    }

    @Test
    fun validCase4_oneColorNeedsBothBoxes() {
        val actual = solution.getProbability(intArrayOf(2, 2))
        assertEquals(1.0, actual, epsilon)
    }

    @Test
    fun validCase5_mixedCounts() {
        val actual = solution.getProbability(intArrayOf(3, 2, 1))
        assertEquals(0.3, actual, epsilon)
    }

    @Test
    fun validCase6_threeEvenlyStockedColors() {
        val actual = solution.getProbability(intArrayOf(6, 6, 6))
        assertEquals(0.9777869189633895, actual, epsilon)
    }
}
