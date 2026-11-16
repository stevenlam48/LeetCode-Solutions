package sortcolors

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SortColorsTest {
    @Test
    fun unsortedColors() {
        val nums = intArrayOf(2, 0, 2, 1, 1, 0)
        Solution().sortColors(nums)
        assertArrayEquals(intArrayOf(0, 0, 1, 1, 2, 2), nums)
    }

    @Test
    fun reverseSortedColors() {
        val nums = intArrayOf(2, 2, 1, 0)
        Solution().sortColors(nums)
        assertArrayEquals(intArrayOf(0, 1, 2, 2), nums)
    }

    @Test
    fun alreadySorted() {
        val nums = intArrayOf(0, 0, 1, 2)
        Solution().sortColors(nums)
        assertArrayEquals(intArrayOf(0, 0, 1, 2), nums)
    }

    @Test
    fun emptyAndSingleElement() {
        val empty = intArrayOf()
        val single = intArrayOf(1)
        Solution().sortColors(empty)
        Solution().sortColors(single)
        assertArrayEquals(intArrayOf(), empty)
        assertArrayEquals(intArrayOf(1), single)
    }
}
