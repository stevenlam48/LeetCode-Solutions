package beautifulpairs

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class BeautifulPairsTest {
    private val solution = Solution()

    @Test
    fun uniqueClosestPair() {
        assertArrayEquals(
            intArrayOf(0, 3),
            solution.beautifulPair(intArrayOf(1, 2, 3, 2, 4), intArrayOf(2, 3, 1, 2, 3))
        )
    }

    @Test
    fun duplicatePointsReturnEarliestPair() {
        assertArrayEquals(
            intArrayOf(0, 2),
            solution.beautifulPair(intArrayOf(1, 2, 1, 3), intArrayOf(4, 5, 4, 6))
        )
    }

    @Test
    fun equalDistancePairsUseLexicographicTieBreak() {
        assertArrayEquals(
            intArrayOf(0, 1),
            solution.beautifulPair(intArrayOf(0, 0, 2, 2), intArrayOf(0, 2, 0, 2))
        )
    }

    @Test
    fun negativeCoordinates() {
        assertArrayEquals(
            intArrayOf(0, 1),
            solution.beautifulPair(intArrayOf(-4, -4, -2, -2), intArrayOf(-3, -1, -3, -1))
        )
    }
}
