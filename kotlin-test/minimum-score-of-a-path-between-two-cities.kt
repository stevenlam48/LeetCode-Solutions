package minimumscoreofapathbetweentwocities

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumScoreOfAPathBetweenTwoCitiesTest {
    @Test
    fun example1() {
        val roads = arrayOf(
            intArrayOf(1, 2, 9),
            intArrayOf(2, 3, 6),
            intArrayOf(2, 4, 5),
            intArrayOf(1, 4, 7)
        )
        assertEquals(5, Solution().minScore(4, roads))
    }

    @Test
    fun example2() {
        val roads = arrayOf(
            intArrayOf(1, 2, 2),
            intArrayOf(1, 3, 4),
            intArrayOf(3, 4, 7)
        )
        assertEquals(2, Solution().minScore(4, roads))
    }

    @Test
    fun twoCities() {
        assertEquals(5, Solution().minScore(2, arrayOf(intArrayOf(1, 2, 5))))
    }

    @Test
    fun unreachableBranchIgnored() {
        val roads = arrayOf(
            intArrayOf(1, 2, 8),
            intArrayOf(3, 4, 1)
        )
        assertEquals(8, Solution().minScore(4, roads))
    }
}
