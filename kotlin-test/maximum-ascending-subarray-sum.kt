package maximumascendingsubarraysum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumAscendingSubarraySumTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertEquals(65, solution.maxAscendingSum(intArrayOf(10, 20, 30, 5, 10, 50)))
    }

    @Test
    fun secondExample() {
        assertEquals(85, solution.maxAscendingSum(intArrayOf(10, 20, 15, 30, 40)))
    }

    @Test
    fun thirdExample() {
        assertEquals(33, solution.maxAscendingSum(intArrayOf(12, 17, 15, 13, 10, 11, 12)))
    }

    @Test
    fun equalValuesStartNewRuns() {
        assertEquals(5, solution.maxAscendingSum(intArrayOf(5, 5, 5)))
    }

    @Test
    fun emptyArray() {
        assertEquals(0, solution.maxAscendingSum(intArrayOf()))
    }
}
