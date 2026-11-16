package maximumproductoffirstandlastelementsofasubsequence

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumProductOfFirstAndLastElementsOfASubsequenceTest {
    @Test
    fun example1() {
        assertEquals(12L, Solution().maximumProduct(intArrayOf(1, 2, 3, 4), 2))
    }

    @Test
    fun mEqualsLength() {
        assertEquals(4L, Solution().maximumProduct(intArrayOf(1, 2, 3, 4), 4))
    }

    @Test
    fun negatives() {
        assertEquals(15L, Solution().maximumProduct(intArrayOf(-1, -2, -3, -4, -5), 3))
    }

    @Test
    fun singleElement() {
        assertEquals(25L, Solution().maximumProduct(intArrayOf(5), 1))
    }

    @Test
    fun mixedSigns() {
        assertEquals(12L, Solution().maximumProduct(intArrayOf(-3, 1, 2, -4), 2))
    }
}
