package coordinatewithmaximumnetworkquality

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class CoordinateWithMaximumNetworkQualityTest {
    private val solution = Solution()

    @Test
    fun testExampleOne() {
        val towers = arrayOf(
            intArrayOf(1, 2, 5),
            intArrayOf(2, 1, 7),
            intArrayOf(3, 1, 9)
        )
        assertArrayEquals(intArrayOf(2, 1), solution.bestCoordinate(towers, 2))
    }

    @Test
    fun testExampleTwo() {
        val towers = arrayOf(
            intArrayOf(1, 2, 13),
            intArrayOf(2, 1, 7),
            intArrayOf(0, 1, 9)
        )
        assertArrayEquals(intArrayOf(1, 2), solution.bestCoordinate(towers, 2))
    }

    @Test
    fun testSingleTower() {
        val towers = arrayOf(intArrayOf(0, 0, 10))
        assertArrayEquals(intArrayOf(0, 0), solution.bestCoordinate(towers, 1))
    }
}
