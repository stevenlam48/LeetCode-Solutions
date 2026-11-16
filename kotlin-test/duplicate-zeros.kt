package duplicatezeros

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class DuplicateZerosTest {
    @Test
    fun example1() {
        val arr = intArrayOf(1, 0, 2, 3, 0, 4, 5, 0)
        Solution().duplicateZeros(arr)
        assertArrayEquals(intArrayOf(1, 0, 0, 2, 3, 0, 0, 4), arr)
    }

    @Test
    fun example2() {
        val arr = intArrayOf(1, 2, 3)
        Solution().duplicateZeros(arr)
        assertArrayEquals(intArrayOf(1, 2, 3), arr)
    }

    @Test
    fun allZeros() {
        val arr = intArrayOf(0, 0, 0)
        Solution().duplicateZeros(arr)
        assertArrayEquals(intArrayOf(0, 0, 0), arr)
    }

    @Test
    fun zeroThenOne() {
        val arr = intArrayOf(0, 1)
        Solution().duplicateZeros(arr)
        assertArrayEquals(intArrayOf(0, 0), arr)
    }

    @Test
    fun trailingZeros() {
        val arr = intArrayOf(8, 4, 5, 0, 0, 0, 0, 7)
        Solution().duplicateZeros(arr)
        assertArrayEquals(intArrayOf(8, 4, 5, 0, 0, 0, 0, 0), arr)
    }
}
