package rotatearray

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class RotateArrayTest {
    @Test
    fun leetCodeExampleRightShiftByThree() {
        val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        Solution().rotate(nums, 3)
        assertArrayEquals(intArrayOf(5, 6, 7, 1, 2, 3, 4), nums)
    }

    @Test
    fun leetCodeExampleWithNegatives() {
        val nums = intArrayOf(-1, -100, 3, 99)
        Solution().rotate(nums, 2)
        assertArrayEquals(intArrayOf(3, 99, -1, -100), nums)
    }

    @Test
    fun zeroShiftKeepsArray() {
        val nums = intArrayOf(1, 2, 3)
        Solution().rotate(nums, 0)
        assertArrayEquals(intArrayOf(1, 2, 3), nums)
    }

    @Test
    fun shiftLargerThanLength() {
        val nums = intArrayOf(1, 2)
        Solution().rotate(nums, 3)
        assertArrayEquals(intArrayOf(2, 1), nums)
    }

    @Test
    fun emptyArray() {
        val nums = IntArray(0)
        Solution().rotate(nums, 5)
        assertArrayEquals(IntArray(0), nums)
    }

    @Test
    fun singleElement() {
        val nums = intArrayOf(7)
        Solution().rotate(nums, 4)
        assertArrayEquals(intArrayOf(7), nums)
    }
}
