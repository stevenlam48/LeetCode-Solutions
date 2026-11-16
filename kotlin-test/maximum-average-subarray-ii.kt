package maximumaveragesubarrayii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumAverageSubarrayIITest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertEquals(12.75, solution.findMaxAverage(intArrayOf(1, 12, -5, -6, 50, 3), 4), 1e-4)
    }

    @Test
    fun longerSubarrayHasBestAverage() {
        assertEquals(5.0, solution.findMaxAverage(intArrayOf(-1, 5, 5, -1), 2), 1e-4)
    }

    @Test
    fun wholeArrayMustBeUsed() {
        assertEquals(2.8, solution.findMaxAverage(intArrayOf(4, 0, 4, 3, 3), 5), 1e-4)
    }

    @Test
    fun increasingArray() {
        assertEquals(3.5, solution.findMaxAverage(intArrayOf(1, 2, 3, 4), 2), 1e-4)
    }

    @Test
    fun singleElement() {
        assertEquals(5.0, solution.findMaxAverage(intArrayOf(5), 1), 1e-4)
    }
}
