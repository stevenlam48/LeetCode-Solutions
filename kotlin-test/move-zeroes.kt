package movezeroes

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MoveZeroesTest {
    @Test
    fun example1() {
        val nums = intArrayOf(0, 1, 0, 3, 12)
        Solution().moveZeroes(nums)
        assertArrayEquals(intArrayOf(1, 3, 12, 0, 0), nums)
    }

    @Test
    fun singleZero() {
        val nums = intArrayOf(0)
        Solution().moveZeroes(nums)
        assertArrayEquals(intArrayOf(0), nums)
    }

    @Test
    fun singleNonZero() {
        val nums = intArrayOf(1)
        Solution().moveZeroes(nums)
        assertArrayEquals(intArrayOf(1), nums)
    }

    @Test
    fun leadingZeros() {
        val nums = intArrayOf(0, 0, 1)
        Solution().moveZeroes(nums)
        assertArrayEquals(intArrayOf(1, 0, 0), nums)
    }

    @Test
    fun noZeros() {
        val nums = intArrayOf(1, 2, 3)
        Solution().moveZeroes(nums)
        assertArrayEquals(intArrayOf(1, 2, 3), nums)
    }
}
