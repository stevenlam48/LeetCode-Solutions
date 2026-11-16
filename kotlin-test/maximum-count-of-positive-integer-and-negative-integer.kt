package maximumcountofpositiveintegerandnegativeinteger

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MaximumCountOfPositiveIntegerAndNegativeIntegerTest {
    private val solution = Solution()

    @Test
    fun equalNegativeAndPositiveCounts() {
        assertEquals(3, solution.maximumCount(intArrayOf(-2, -1, -1, 1, 2, 3)))
    }

    @Test
    fun zerosAreExcluded() {
        assertEquals(3, solution.maximumCount(intArrayOf(-3, -2, -1, 0, 0, 1, 2)))
    }

    @Test
    fun onlyZeros() {
        assertEquals(0, solution.maximumCount(intArrayOf(0, 0, 0)))
    }

    @Test
    fun allPositive() {
        assertEquals(4, solution.maximumCount(intArrayOf(5, 20, 66, 1314)))
    }
}
