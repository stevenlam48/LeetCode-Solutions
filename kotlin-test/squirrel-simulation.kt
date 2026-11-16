package squirrelsimulation

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SquirrelSimulationTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(
            12,
            solution.minDistance(5, 7, intArrayOf(2, 2), intArrayOf(4, 4), arrayOf(intArrayOf(3, 0), intArrayOf(2, 5)))
        )
    }

    @Test
    fun testSingleNut() {
        assertEquals(3, solution.minDistance(1, 3, intArrayOf(0, 1), intArrayOf(0, 0), arrayOf(intArrayOf(0, 2))))
    }

    @Test
    fun testNutAtTree() {
        assertEquals(1, solution.minDistance(1, 2, intArrayOf(0, 0), intArrayOf(0, 1), arrayOf(intArrayOf(0, 0))))
    }

    @Test
    fun testSquirrelAtTree() {
        assertEquals(
            8,
            solution.minDistance(3, 3, intArrayOf(1, 1), intArrayOf(1, 1), arrayOf(intArrayOf(0, 0), intArrayOf(2, 2)))
        )
    }
}
