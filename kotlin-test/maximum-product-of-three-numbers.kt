package maximumproductofthreenumbers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumProductOfThreeNumbersTest {
    @Test
    fun example1() {
        assertEquals(6, Solution().maximumProduct(intArrayOf(1, 2, 3)))
    }

    @Test
    fun example2() {
        assertEquals(24, Solution().maximumProduct(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun allNegative() {
        assertEquals(-6, Solution().maximumProduct(intArrayOf(-1, -2, -3)))
    }

    @Test
    fun twoNegatives() {
        assertEquals(300, Solution().maximumProduct(intArrayOf(-100, -2, -3, 1)))
    }

    @Test
    fun zeros() {
        assertEquals(0, Solution().maximumProduct(intArrayOf(0, 0, 0)))
    }
}
