package defusethebomb

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class DefuseTheBombTest {
    private val solution = Solution()

    @Test
    fun positiveK() {
        assertArrayEquals(intArrayOf(12, 10, 16, 13), solution.decrypt(intArrayOf(5, 7, 1, 4), 3))
    }

    @Test
    fun negativeK() {
        assertArrayEquals(intArrayOf(7, 5, 3, 5), solution.decrypt(intArrayOf(1, 2, 3, 4), -2))
    }

    @Test
    fun zeroK() {
        assertArrayEquals(intArrayOf(0, 0, 0, 0), solution.decrypt(intArrayOf(2, 4, 9, 3), 0))
    }

    @Test
    fun wrapsAroundCircularArray() {
        assertArrayEquals(intArrayOf(14, 13, 12, 11, 10), solution.decrypt(intArrayOf(1, 2, 3, 4, 5), 4))
    }
}
