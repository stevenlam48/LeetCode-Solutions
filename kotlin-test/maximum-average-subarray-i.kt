package maximumaveragesubarrayi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumAverageSubarrayITest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertEquals(12.75, solution.findMaxAverage(intArrayOf(1, 12, -5, -6, 50, 3), 4), 0.0)
    }

    @Test
    fun negativeNumbers() {
        assertEquals(-1.5, solution.findMaxAverage(intArrayOf(-1, -2, -3), 2), 0.0)
    }

    @Test
    fun windowOfOneSelectsMaximumElement() {
        assertEquals(7.0, solution.findMaxAverage(intArrayOf(3, 7, -2), 1), 0.0)
    }

    @Test
    fun wholeArrayIsOnlyWindow() {
        assertEquals(2.0, solution.findMaxAverage(intArrayOf(1, 2, 3), 3), 0.0)
    }
}
