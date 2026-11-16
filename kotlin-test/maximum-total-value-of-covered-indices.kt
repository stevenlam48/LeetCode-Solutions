package maximumtotalvalueofcoveredindices

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumTotalValueOfCoveredIndicesTest {
    @Test
    fun examples() {
        assertEquals(6L, Solution().maxTotal(intArrayOf(1, 2, 3, 4), "0101"))
        assertEquals(5L, Solution().maxTotal(intArrayOf(1, 2, 3, 4), "0110"))
    }

    @Test
    fun allCoveredOrUncovered() {
        assertEquals(10L, Solution().maxTotal(intArrayOf(1, 2, 3, 4), "1111"))
        assertEquals(0L, Solution().maxTotal(intArrayOf(1, 2, 3, 4), "0000"))
    }

    @Test
    fun negativeValues() {
        assertEquals(-3L, Solution().maxTotal(intArrayOf(-2, -5, -1), "011"))
        assertEquals(0L, Solution().maxTotal(intArrayOf(-4), "1"))
    }
}
