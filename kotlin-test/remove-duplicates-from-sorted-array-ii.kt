package removeduplicatesfromsortedarrayii

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveDuplicatesFromSortedArrayIiTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val nums = intArrayOf(1, 1, 1, 2, 2, 3)
        assertEquals(5, solution.removeDuplicates(nums))
        assertArrayEquals(intArrayOf(1, 1, 2, 2, 3), nums.copyOfRange(0, 5))
    }

    @Test
    fun testExample2() {
        val nums = intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3)
        assertEquals(7, solution.removeDuplicates(nums))
        assertArrayEquals(intArrayOf(0, 0, 1, 1, 2, 3, 3), nums.copyOfRange(0, 7))
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
    fun testExactlyTwoDuplicates() {
        val nums = intArrayOf(1, 1)
        assertEquals(2, solution.removeDuplicates(nums))
        assertArrayEquals(intArrayOf(1, 1), nums.copyOfRange(0, 2))
    }

    @Test
    fun testThreeDuplicates() {
        val nums = intArrayOf(1, 1, 1)
        assertEquals(2, solution.removeDuplicates(nums))
        assertArrayEquals(intArrayOf(1, 1), nums.copyOfRange(0, 2))
    }
}
