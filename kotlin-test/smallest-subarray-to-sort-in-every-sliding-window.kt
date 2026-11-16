package smallestsubarraytosortineveryslidingwindow

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SmallestSubarrayToSortInEverySlidingWindowTest {
    private val solution = Solution()

    @Test
    fun windowSizeOne() {
        assertArrayEquals(intArrayOf(0, 0, 0, 0), solution.minSubarraySort(intArrayOf(3, 1, 2, 0), 1))
    }

    @Test
    fun adjacentDisorder() {
        assertArrayEquals(intArrayOf(0, 2, 0), solution.minSubarraySort(intArrayOf(1, 3, 2, 4), 2))
        assertArrayEquals(intArrayOf(2, 2), solution.minSubarraySort(intArrayOf(1, 3, 2, 4), 3))
        assertArrayEquals(intArrayOf(2), solution.minSubarraySort(intArrayOf(1, 3, 2, 4), 4))
    }

    @Test
    fun sortedWindowsNeedNoSorting() {
        assertArrayEquals(intArrayOf(0, 0), solution.minSubarraySort(intArrayOf(1, 2, 3), 2))
    }

    @Test
    fun reverseSortedWindowsNeedFullSorting() {
        assertArrayEquals(intArrayOf(2, 2, 2), solution.minSubarraySort(intArrayOf(4, 3, 2, 1), 2))
        assertArrayEquals(intArrayOf(3, 3), solution.minSubarraySort(intArrayOf(4, 3, 2, 1), 3))
    }
}
