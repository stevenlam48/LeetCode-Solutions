package binarysearch

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinarySearchTest {
    @Test
    fun example1() {
        assertEquals(4, Solution().search(intArrayOf(-1, 0, 3, 5, 9, 12), 9))
    }

    @Test
    fun example2() {
        assertEquals(-1, Solution().search(intArrayOf(-1, 0, 3, 5, 9, 12), 2))
    }

    @Test
    fun singleElementFound() {
        assertEquals(0, Solution().search(intArrayOf(5), 5))
    }

    @Test
    fun singleElementMissing() {
        assertEquals(-1, Solution().search(intArrayOf(5), -5))
    }

    @Test
    fun emptyInput() {
        assertEquals(-1, Solution().search(intArrayOf(), 1))
    }

    @Test
    fun firstAndLast() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        assertEquals(0, Solution().search(nums, 1))
        assertEquals(4, Solution().search(nums, 5))
    }
}
