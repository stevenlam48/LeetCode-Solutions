package peakindexinamountainarray

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PeakIndexInMountainArrayTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(1, solution.peakIndexInMountainArray(intArrayOf(0, 1, 0)))
    }

    @Test
    fun testExample2() {
        assertEquals(1, solution.peakIndexInMountainArray(intArrayOf(0, 2, 1, 0)))
    }

    @Test
    fun testExample3() {
        assertEquals(1, solution.peakIndexInMountainArray(intArrayOf(0, 10, 5, 2)))
    }

    @Test
    fun testPeakNearEnd() {
        assertEquals(2, solution.peakIndexInMountainArray(intArrayOf(3, 4, 5, 1)))
    }
}
