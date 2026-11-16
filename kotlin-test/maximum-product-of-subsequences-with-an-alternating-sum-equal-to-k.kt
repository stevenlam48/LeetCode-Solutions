package maximumproductofsubsequenceswithanalternatingsumequaltok

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumProductOfSubsequencesWithAnAlternatingSumEqualToKTest {
    @Test
    fun example1() {
        assertEquals(6, Solution().maxProduct(intArrayOf(1, 2, 3), 2, 10))
    }

    @Test
    fun pairWithZeroSum() {
        assertEquals(1, Solution().maxProduct(intArrayOf(1, 1), 0, 5))
    }

    @Test
    fun singleElement() {
        assertEquals(1, Solution().maxProduct(intArrayOf(1), 1, 1))
    }

    @Test
    fun productExceedsLimit() {
        assertEquals(-1, Solution().maxProduct(intArrayOf(2, 2), 0, 3))
    }

    @Test
    fun unreachableSum() {
        assertEquals(-1, Solution().maxProduct(intArrayOf(1, 2), 3, 10))
    }

    @Test
    fun negativeSumUnreachable() {
        assertEquals(-1, Solution().maxProduct(intArrayOf(5), -5, 10))
    }
}
