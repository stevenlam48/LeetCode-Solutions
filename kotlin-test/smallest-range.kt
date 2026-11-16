package smallestrange

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SmallestRangeTest {
    private val solution = Solution()

    @Test
    fun example() {
        val nums = arrayOf(
            intArrayOf(4, 10, 15, 24, 26),
            intArrayOf(0, 9, 12, 20),
            intArrayOf(5, 18, 22, 30)
        )
        assertArrayEquals(intArrayOf(20, 24), solution.smallestRange(nums))
    }

    @Test
    fun singleList() {
        assertArrayEquals(intArrayOf(1, 1), solution.smallestRange(arrayOf(intArrayOf(1, 2, 3))))
    }

    @Test
    fun keepsFirstRangeWhenLengthsTie() {
        val nums = arrayOf(intArrayOf(1, 4), intArrayOf(2, 5), intArrayOf(3, 6))
        assertArrayEquals(intArrayOf(1, 3), solution.smallestRange(nums))
    }

    @Test
    fun duplicateValues() {
        val nums = arrayOf(intArrayOf(1), intArrayOf(1), intArrayOf(1))
        assertArrayEquals(intArrayOf(1, 1), solution.smallestRange(nums))
    }
}
