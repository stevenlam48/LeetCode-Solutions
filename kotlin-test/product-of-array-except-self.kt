package productofarrayexceptself

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ProductOfArrayExceptSelfTest {
    private val solution = Solution()

    @Test
    fun validCase1() {
        val actual = solution.productExceptSelf(intArrayOf(1, 2, 3, 4))
        assertArrayEquals(intArrayOf(24, 12, 8, 6), actual)
    }

    @Test
    fun validCase2_oneZero() {
        val actual = solution.productExceptSelf(intArrayOf(-1, 1, 0, -3, 3))
        assertArrayEquals(intArrayOf(0, 0, 9, 0, 0), actual)
    }

    @Test
    fun validCase3_twoNumbers() {
        val actual = solution.productExceptSelf(intArrayOf(2, 3))
        assertArrayEquals(intArrayOf(3, 2), actual)
    }

    @Test
    fun validCase4_twoZeros() {
        val actual = solution.productExceptSelf(intArrayOf(0, 0))
        assertArrayEquals(intArrayOf(0, 0), actual)
    }

    @Test
    fun validCase5_negativeNumbers() {
        val actual = solution.productExceptSelf(intArrayOf(-1, -2, -3, -4))
        assertArrayEquals(intArrayOf(-24, -12, -8, -6), actual)
    }

    @Test
    fun validCase6_singleNumber() {
        val actual = solution.productExceptSelf(intArrayOf(5))
        assertArrayEquals(intArrayOf(1), actual)
    }
}
