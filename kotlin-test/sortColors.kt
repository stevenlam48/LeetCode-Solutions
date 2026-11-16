package sortColorsOld

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SortColorsTest {
    @Test
    fun unsortedColors() {
        val a = intArrayOf(2, 0, 2, 1, 1, 0)
        Solution().sortColors(a, a.size)
        assertArrayEquals(intArrayOf(0, 0, 1, 1, 2, 2), a)
    }

    @Test
    fun reverseSortedColors() {
        val a = intArrayOf(2, 2, 1, 0)
        Solution().sortColors(a, a.size)
        assertArrayEquals(intArrayOf(0, 1, 2, 2), a)
    }

    @Test
    fun alreadySorted() {
        val a = intArrayOf(0, 0, 1, 2)
        Solution().sortColors(a, a.size)
        assertArrayEquals(intArrayOf(0, 0, 1, 2), a)
    }

    @Test
    fun emptyAndSingleElement() {
        val empty = intArrayOf()
        val single = intArrayOf(1)
        Solution().sortColors(empty, empty.size)
        Solution().sortColors(single, single.size)
        assertArrayEquals(intArrayOf(), empty)
        assertArrayEquals(intArrayOf(1), single)
    }
}