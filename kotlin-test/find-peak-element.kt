package findpeakelement

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindPeakElementTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(2, solution.findPeakElement(intArrayOf(1, 2, 3, 1)))
    }

    @Test
    fun exampleTwo() {
        assertEquals(5, solution.findPeakElement(intArrayOf(1, 2, 1, 3, 5, 6, 4)))
    }

    @Test
    fun singleElement() {
        assertEquals(0, solution.findPeakElement(intArrayOf(7)))
    }

    @Test
    fun peakAtBoundary() {
        assertEquals(0, solution.findPeakElement(intArrayOf(5, 4, 3, 2, 1)))
        assertEquals(4, solution.findPeakElement(intArrayOf(1, 2, 3, 4, 5)))
    }
}
