package checkifbitwiseorhastrailingzeros

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CheckIfBitwiseOrHasTrailingZerosTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertTrue(solution.hasTrailingZeros(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun testAllEven() {
        assertTrue(solution.hasTrailingZeros(intArrayOf(2, 4, 8, 16)))
    }

    @Test
    fun testAllOdd() {
        assertFalse(solution.hasTrailingZeros(intArrayOf(1, 3, 5, 7, 9)))
    }

    @Test
    fun testSingleEven() {
        assertFalse(solution.hasTrailingZeros(intArrayOf(2)))
    }

    @Test
    fun testZeroAndOdd() {
        assertFalse(solution.hasTrailingZeros(intArrayOf(0, 1)))
    }

    @Test
    fun testTwoEvens() {
        assertTrue(solution.hasTrailingZeros(intArrayOf(2, 4)))
    }
}
