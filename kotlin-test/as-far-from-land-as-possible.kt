package asfarfromlandaspossible

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AsFarFromLandAsPossibleTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(
            2,
            solution.maxDistance(
                arrayOf(
                    intArrayOf(1, 0, 1),
                    intArrayOf(0, 0, 0),
                    intArrayOf(1, 0, 1)
                )
            )
        )
    }

    @Test
    fun testExample2() {
        assertEquals(
            4,
            solution.maxDistance(
                arrayOf(
                    intArrayOf(1, 0, 0),
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 0, 0)
                )
            )
        )
    }

    @Test
    fun testAllLand() {
        assertEquals(-1, solution.maxDistance(arrayOf(intArrayOf(1, 1), intArrayOf(1, 1))))
    }

    @Test
    fun testAllWater() {
        assertEquals(-1, solution.maxDistance(arrayOf(intArrayOf(0, 0), intArrayOf(0, 0))))
    }

    @Test
    fun testSingleCell() {
        assertEquals(-1, solution.maxDistance(arrayOf(intArrayOf(0))))
        assertEquals(-1, solution.maxDistance(arrayOf(intArrayOf(1))))
    }
}
