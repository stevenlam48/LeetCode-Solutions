package wigglesort

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class WiggleSortTest {
    private val solution = Solution()

    @Test
    fun example1() {
        val nums = intArrayOf(3, 5, 2, 1, 6, 4)
        solution.wiggleSort(nums)
        assertArrayEquals(intArrayOf(3, 5, 1, 6, 2, 4), nums)
    }

    @Test
    fun alreadySorted() {
        val nums = intArrayOf(1, 2, 3, 4)
        solution.wiggleSort(nums)
        assertArrayEquals(intArrayOf(1, 3, 2, 4), nums)
    }

    @Test
    fun singleElement() {
        val nums = intArrayOf(1)
        solution.wiggleSort(nums)
        assertArrayEquals(intArrayOf(1), nums)
    }

    @Test
    fun twoElements() {
        val nums = intArrayOf(2, 1)
        solution.wiggleSort(nums)
        assertArrayEquals(intArrayOf(1, 2), nums)
    }

    @Test
    fun duplicates() {
        val nums = intArrayOf(1, 1, 2, 2)
        solution.wiggleSort(nums)
        assertArrayEquals(intArrayOf(1, 2, 1, 2), nums)
    }
}
