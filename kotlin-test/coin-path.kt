package coinpath

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class CoinPathTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertArrayEquals(intArrayOf(1, 3, 5), solution.cheapestJump(intArrayOf(1, 2, 4, -1, 2), 2))
    }

    @Test
    fun testBlockedEnd() {
        assertArrayEquals(intArrayOf(), solution.cheapestJump(intArrayOf(1, 2, 4, -1, 2), 1))
    }

    @Test
    fun testSmallestPathPreferred() {
        assertArrayEquals(intArrayOf(1, 3), solution.cheapestJump(intArrayOf(1, 2, 3), 2))
    }

    @Test
    fun testSingleElement() {
        assertArrayEquals(intArrayOf(1), solution.cheapestJump(intArrayOf(1), 1))
    }

    @Test
    fun testNoValidPath() {
        assertArrayEquals(intArrayOf(), solution.cheapestJump(intArrayOf(-1), 1))
        assertArrayEquals(intArrayOf(), solution.cheapestJump(intArrayOf(1, -1, 2), 1))
    }

    @Test
    fun testLargerJump() {
        assertArrayEquals(intArrayOf(1, 2, 5), solution.cheapestJump(intArrayOf(1, 2, 4, -1, 2), 3))
    }
}
