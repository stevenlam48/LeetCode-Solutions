package maximizethedistancebetweenpointsonasquare

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeTheDistanceBetweenPointsOnASquareTest {
    @Test
    fun exampleOne() {
        val points = arrayOf(
            intArrayOf(0, 2),
            intArrayOf(2, 0),
            intArrayOf(2, 2),
            intArrayOf(0, 0)
        )
        assertEquals(2, Solution().maxDistance(2, points, 4))
    }

    @Test
    fun exampleTwo() {
        val points = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(1, 2),
            intArrayOf(2, 0),
            intArrayOf(2, 2),
            intArrayOf(2, 1)
        )
        assertEquals(1, Solution().maxDistance(2, points, 4))
    }

    @Test
    fun twoPoints() {
        val points = arrayOf(intArrayOf(0, 0), intArrayOf(0, 2))
        assertEquals(2, Solution().maxDistance(2, points, 2))
    }
}
