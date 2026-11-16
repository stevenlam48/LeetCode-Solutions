package rotatenonnegativeelements

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class RotateNonNegativeElementsTest {
    @Test
    fun negativesStayInPlace() {
        val nums = intArrayOf(1, -2, 3, 4, -5)
        assertArrayEquals(intArrayOf(3, -2, 4, 1, -5), Solution().rotateElements(nums, 1))
    }

    @Test
    fun allNegativeUnchanged() {
        val nums = intArrayOf(-1, -2)
        assertArrayEquals(intArrayOf(-1, -2), Solution().rotateElements(nums, 3))
    }

    @Test
    fun zeroShiftUnchanged() {
        val nums = intArrayOf(1, -1, 2)
        assertArrayEquals(intArrayOf(1, -1, 2), Solution().rotateElements(nums, 0))
    }

    @Test
    fun shiftEqualToCount() {
        val nums = intArrayOf(-1, 2, 3)
        assertArrayEquals(intArrayOf(-1, 2, 3), Solution().rotateElements(nums, 2))
    }

    @Test
    fun zeroIsNonNegative() {
        val nums = intArrayOf(0, -1, 2)
        assertArrayEquals(intArrayOf(2, -1, 0), Solution().rotateElements(nums, 1))
    }

    @Test
    fun shiftLargerThanCount() {
        val nums = intArrayOf(1, 2, 3)
        assertArrayEquals(intArrayOf(3, 1, 2), Solution().rotateElements(nums, 5))
    }
}
