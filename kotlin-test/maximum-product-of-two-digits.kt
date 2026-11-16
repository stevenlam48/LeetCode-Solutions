package maximumproductoftwodigits

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumProductOfTwoDigitsTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().maxProduct(31))
    }

    @Test
    fun example2() {
        assertEquals(4, Solution().maxProduct(22))
    }

    @Test
    fun threeDigits() {
        assertEquals(8, Solution().maxProduct(124))
    }

    @Test
    fun withZero() {
        assertEquals(0, Solution().maxProduct(10))
    }

    @Test
    fun allNines() {
        assertEquals(81, Solution().maxProduct(99))
    }

    @Test
    fun hundred() {
        assertEquals(0, Solution().maxProduct(100))
    }
}
