package arrayofdoubledpairs

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class ArrayOfDoubledPairsTest {
    private val solution = Solution()

    @Test
    fun testExampleTrue() {
        assertTrue(solution.canReorderDoubled(intArrayOf(4, -2, 2, -4)))
    }

    @Test
    fun testExampleFalse() {
        assertFalse(solution.canReorderDoubled(intArrayOf(3, 1, 3, 6)))
        assertFalse(solution.canReorderDoubled(intArrayOf(2, 1, 2, 6)))
    }

    @Test
    fun testNegatives() {
        assertTrue(solution.canReorderDoubled(intArrayOf(4, -2, 2, -4, 8, -8, 16, -16, 32, -32, 64, -64)))
        assertFalse(solution.canReorderDoubled(intArrayOf(1, 2, 3)))
    }

    @Test
    fun testZeros() {
        assertTrue(solution.canReorderDoubled(intArrayOf(0, 0)))
        assertFalse(solution.canReorderDoubled(intArrayOf(0, 1)))
    }

    @Test
    fun testPowersOfTwo() {
        assertTrue(solution.canReorderDoubled(intArrayOf(1, 2, 4, 8)))
    }
}
