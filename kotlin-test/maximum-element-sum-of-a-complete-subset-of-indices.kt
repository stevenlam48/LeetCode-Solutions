package maximumelementsumofacompletesubsetofindices

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumElementSumOfACompleteSubsetOfIndicesTest {
    @Test
    fun example1() {
        assertEquals(16L, Solution().maximumSum(intArrayOf(8, 7, 3, 5, 7, 2, 4, 9)))
    }

    @Test
    fun example2() {
        assertEquals(20L, Solution().maximumSum(intArrayOf(8, 10, 3, 8, 1, 13, 7, 9, 4)))
    }

    @Test
    fun singleElement() {
        assertEquals(5L, Solution().maximumSum(intArrayOf(5)))
    }

    @Test
    fun allOnes() {
        assertEquals(2L, Solution().maximumSum(intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun largeValues() {
        assertEquals(2000000000L, Solution().maximumSum(intArrayOf(1000000000, 1000000000, 1000000000, 1000000000)))
    }
}
