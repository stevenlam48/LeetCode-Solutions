package kthlargestelementinanarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KthLargestElementInAnArrayTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(5, solution.findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2))
    }

    @Test
    fun example2() {
        assertEquals(4, solution.findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4))
    }

    @Test
    fun singleElement() {
        assertEquals(1, solution.findKthLargest(intArrayOf(1), 1))
    }

    @Test
    fun twoElements() {
        assertEquals(1, solution.findKthLargest(intArrayOf(2, 1), 2))
    }

    @Test
    fun allDuplicates() {
        assertEquals(3, solution.findKthLargest(intArrayOf(3, 3, 3, 3), 2))
    }

    @Test
    fun negatives() {
        assertEquals(-1, solution.findKthLargest(intArrayOf(-1, -2), 1))
    }
}
