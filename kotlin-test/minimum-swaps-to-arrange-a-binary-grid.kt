package minimumswapstoarrangeabinarygrid

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumSwapsToArrangeABinaryGridTest {
    private val solution = Solution()

    @Test
    fun testStandardExample() {
        val grid = arrayOf(
            intArrayOf(0, 0, 1),
            intArrayOf(1, 1, 0),
            intArrayOf(1, 0, 0)
        )
        assertEquals(3, solution.minSwaps(grid))
    }

    @Test
    fun testAnotherArrangement() {
        val grid = arrayOf(
            intArrayOf(0, 0, 1),
            intArrayOf(1, 0, 0),
            intArrayOf(0, 1, 0)
        )
        assertEquals(2, solution.minSwaps(grid))
    }

    @Test
    fun testAlreadyUpperTriangular() {
        val grid = arrayOf(
            intArrayOf(1, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 1)
        )
        assertEquals(0, solution.minSwaps(grid))
    }

    @Test
    fun testImpossible() {
        val grid = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1)
        )
        assertEquals(-1, solution.minSwaps(grid))
    }

    @Test
    fun testSingleCell() {
        assertEquals(0, solution.minSwaps(arrayOf(intArrayOf(0))))
        assertEquals(0, solution.minSwaps(arrayOf(intArrayOf(1))))
    }
}
