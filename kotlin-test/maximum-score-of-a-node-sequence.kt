package maximumscoreofanodesequence

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumScoreOfANodeSequenceTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        val scores = intArrayOf(5, 2, 9, 8, 4)
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(0, 2),
            intArrayOf(1, 3),
            intArrayOf(2, 4)
        )
        assertEquals(24, solution.maximumScore(scores, edges))
    }

    @Test
    fun exampleTwoHasNoValidSequence() {
        val scores = intArrayOf(9, 20, 6, 4, 11, 12)
        val edges = arrayOf(
            intArrayOf(0, 3),
            intArrayOf(5, 3),
            intArrayOf(2, 4),
            intArrayOf(1, 3)
        )
        assertEquals(-1, solution.maximumScore(scores, edges))
    }

    @Test
    fun simplePathOfFourNodes() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3))
        assertEquals(10, solution.maximumScore(intArrayOf(1, 2, 3, 4), edges))
    }

    @Test
    fun choosesBestFourNodeSectionOfLongerPath() {
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4)
        )
        assertEquals(20, solution.maximumScore(intArrayOf(1, 8, 3, 7, 2), edges))
    }
}
