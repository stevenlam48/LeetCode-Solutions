package maximumproductoftwointegerswithnocommonbits

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumProductOfTwoIntegersWithNoCommonBitsTest {
    @Test
    fun example1() {
        assertEquals(12L, Solution().maxProduct(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun disjointPowers() {
        assertEquals(32L, Solution().maxProduct(intArrayOf(4, 8)))
    }

    @Test
    fun small() {
        assertEquals(2L, Solution().maxProduct(intArrayOf(1, 2, 3)))
    }

    @Test
    fun singleElement() {
        assertEquals(0L, Solution().maxProduct(intArrayOf(7)))
    }

    @Test
    fun sameValue() {
        assertEquals(0L, Solution().maxProduct(intArrayOf(1, 1)))
    }
}
