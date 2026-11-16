package findingthenumberofvisiblemountains

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindingTheNumberOfVisibleMountainsTest {
    @Test
    fun example() {
        val peaks = arrayOf(intArrayOf(2, 2), intArrayOf(6, 3), intArrayOf(5, 4))
        assertEquals(2, Solution().visibleMountains(peaks))
    }

    @Test
    fun duplicatePeaks() {
        val peaks = arrayOf(intArrayOf(1, 3), intArrayOf(1, 3))
        assertEquals(0, Solution().visibleMountains(peaks))
    }

    @Test
    fun singlePeak() {
        val peaks = arrayOf(intArrayOf(1, 1))
        assertEquals(1, Solution().visibleMountains(peaks))
    }

    @Test
    fun largestMountainCoversOthers() {
        val peaks = arrayOf(intArrayOf(1, 1), intArrayOf(2, 2), intArrayOf(3, 3))
        assertEquals(1, Solution().visibleMountains(peaks))
    }

    @Test
    fun emptyInput() {
        assertEquals(0, Solution().visibleMountains(arrayOf()))
    }
}
