package maximumproductdifferencebetweentwopairs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumProductDifferenceBetweenTwoPairsTest {
    @Test
    fun example1() {
        assertEquals(34, Solution().maxProductDifference(intArrayOf(5, 6, 2, 7, 4)))
    }

    @Test
    fun example2() {
        assertEquals(64, Solution().maxProductDifference(intArrayOf(4, 2, 5, 9, 7, 4, 8)))
    }

    @Test
    fun allEqual() {
        assertEquals(0, Solution().maxProductDifference(intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun fourElements() {
        assertEquals(10, Solution().maxProductDifference(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun negatives() {
        assertEquals(-12, Solution().maxProductDifference(intArrayOf(-1, -2, -3, -4)))
    }
}
