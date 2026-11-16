package goodindicesinadigitstring

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class GoodIndicesInADigitStringTest {
    @Test
    fun `single digit indices match their digits`() {
        assertArrayEquals(IntArray(10) { it }, Solution().goodIndices("01234567890"))
    }

    @Test
    fun `multi digit index is recognized`() {
        assertArrayEquals(intArrayOf(0, 10), Solution().goodIndices("00000000010"))
    }

    @Test
    fun `nonmatches and leading zeroes`() {
        val solution = Solution()
        assertArrayEquals(intArrayOf(0), solution.goodIndices("0".repeat(12)))
        assertArrayEquals(intArrayOf(1), solution.goodIndices("11111111111"))
        assertArrayEquals(IntArray(0), solution.goodIndices(""))
    }
}
