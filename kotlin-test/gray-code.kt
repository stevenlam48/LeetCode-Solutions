package graycode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GrayCodeTest {
    @Test
    fun `zero and one bit`() {
        val solution = Solution()
        assertArrayEquals(intArrayOf(0), solution.grayCode(0))
        assertArrayEquals(intArrayOf(0, 1), solution.grayCode(1))
    }

    @Test
    fun `standard examples`() {
        val solution = Solution()
        assertArrayEquals(intArrayOf(0, 1, 3, 2), solution.grayCode(2))
        assertArrayEquals(intArrayOf(0, 1, 3, 2, 6, 7, 5, 4), solution.grayCode(3))
    }

    @Test
    fun `adjacent values differ by one bit`() {
        val result = Solution().grayCode(4)
        assertEquals(16, result.size)
        assertEquals(16, result.toSet().size)
        for (i in result.indices) {
            val difference = result[i] xor result[(i + 1) % result.size]
            assertEquals(1, difference.countOneBits())
        }
    }
}
