package intersectionofmultiplearrays

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class IntersectionOfMultipleArraysTest {
    @Test
    fun solvesLeetCodeExample() {
        val nums = arrayOf(
            intArrayOf(3, 1, 2, 4, 5),
            intArrayOf(1, 2, 3, 4),
            intArrayOf(3, 4, 5, 6)
        )
        assertArrayEquals(intArrayOf(3, 4), Solution().intersection(nums))
    }

    @Test
    fun handlesSingleArray() {
        assertArrayEquals(intArrayOf(1, 2, 3), Solution().intersection(arrayOf(intArrayOf(3, 1, 2))))
    }

    @Test
    fun returnsEmptyForDisjointArrays() {
        assertArrayEquals(
            IntArray(0),
            Solution().intersection(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)))
        )
    }

    @Test
    fun returnsSortedIntersectionRegardlessOfInputOrder() {
        val nums = arrayOf(intArrayOf(1000, 1, 50), intArrayOf(50, 1000, 1), intArrayOf(1, 50, 1000))
        assertArrayEquals(intArrayOf(1, 50, 1000), Solution().intersection(nums))
    }
}
