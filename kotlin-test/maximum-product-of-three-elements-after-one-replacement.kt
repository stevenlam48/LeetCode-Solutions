package maximumproductofthreeelementsafteronereplacement

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumProductOfThreeElementsAfterOneReplacementTest {
    @Test
    fun example1() {
        assertEquals(600000L, Solution().maxProduct(intArrayOf(1, 2, 3)))
    }

    @Test
    fun negatives() {
        assertEquals(4200000L, Solution().maxProduct(intArrayOf(-5, -6, -7)))
    }

    @Test
    fun allOnes() {
        assertEquals(100000L, Solution().maxProduct(intArrayOf(1, 1, 1)))
    }

    @Test
    fun mixedSigns() {
        assertEquals(900000L, Solution().maxProduct(intArrayOf(3, -3, 3)))
    }

    @Test
    fun zeros() {
        assertEquals(0L, Solution().maxProduct(intArrayOf(0, 0, 0)))
    }
}
