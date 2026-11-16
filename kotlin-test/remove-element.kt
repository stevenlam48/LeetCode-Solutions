package removeelement

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveElementTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val nums = intArrayOf(3, 2, 2, 3)
        assertEquals(2, solution.removeElement(nums, 3))
        assertArrayEquals(intArrayOf(2, 2), nums.copyOfRange(0, 2).sortedArray())
    }

    @Test
    fun testExample2() {
        val nums = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2)
        assertEquals(5, solution.removeElement(nums, 2))
        assertArrayEquals(intArrayOf(0, 0, 1, 3, 4), nums.copyOfRange(0, 5).sortedArray())
    }

    @Test
    fun testEmptyArray() {
        assertEquals(0, solution.removeElement(intArrayOf(), 1))
    }

    @Test
    fun testSingleElementRemoved() {
        assertEquals(0, solution.removeElement(intArrayOf(1), 1))
    }

    @Test
    fun testNoOccurrences() {
        val nums = intArrayOf(4, 5)
        assertEquals(1, solution.removeElement(nums, 5))
        assertArrayEquals(intArrayOf(4), nums.copyOfRange(0, 1))
    }
}
