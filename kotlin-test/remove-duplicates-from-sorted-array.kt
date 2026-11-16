package removeduplicatesfromsortedarray

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveDuplicatesFromSortedArrayTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val nums = intArrayOf(1, 1, 2)
        assertEquals(2, solution.removeDuplicates(nums))
        assertArrayEquals(intArrayOf(1, 2), nums.copyOfRange(0, 2))
    }

    @Test
    fun testExample2() {
        val nums = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
        assertEquals(5, solution.removeDuplicates(nums))
        assertArrayEquals(intArrayOf(0, 1, 2, 3, 4), nums.copyOfRange(0, 5))
    }

    @Test
    fun testEmptyArray() {
        assertEquals(0, solution.removeDuplicates(intArrayOf()))
    }

    @Test
    fun testSingleElement() {
        val nums = intArrayOf(1)
        assertEquals(1, solution.removeDuplicates(nums))
        assertArrayEquals(intArrayOf(1), nums.copyOfRange(0, 1))
    }

    @Test
    fun testNegatives() {
        val nums = intArrayOf(-3, -3, -1, 0, 0)
        assertEquals(3, solution.removeDuplicates(nums))
        assertArrayEquals(intArrayOf(-3, -1, 0), nums.copyOfRange(0, 3))
    }
}
