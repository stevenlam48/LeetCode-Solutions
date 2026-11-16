package maximumpointsinanarcherycompetition

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MaximumPointsInAnArcheryCompetitionTest {
    @Test
    fun firstExample() {
        val alice = intArrayOf(1, 1, 0, 1, 0, 0, 2, 1, 0, 1, 2, 0)
        val expected = intArrayOf(0, 0, 0, 0, 1, 1, 0, 0, 1, 2, 3, 1)
        assertArrayEquals(expected, Solution().maximumBobPoints(9, alice))
    }

    @Test
    fun combinesHigherScoringSections() {
        val alice = IntArray(12)
        alice[2] = 1
        alice[11] = 3
        val expected = IntArray(12)
        expected[8] = 1
        expected[9] = 1
        expected[10] = 1
        assertArrayEquals(expected, Solution().maximumBobPoints(3, alice))
    }

    @Test
    fun leftoverArrowsGoToLastSection() {
        assertArrayEquals(intArrayOf(0, 2), Solution().maximumBobPoints(2, intArrayOf(0, 0)))
    }

    @Test
    fun noArrows() {
        assertArrayEquals(IntArray(12), Solution().maximumBobPoints(0, IntArray(12)))
    }
}
