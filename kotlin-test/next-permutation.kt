package nextpermutation

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class NextPermutationTest {
    @Test
    fun `moves to immediate next permutation`() {
        val nums = intArrayOf(1, 2, 3)
        Solution().nextPermutation(nums)
        assertArrayEquals(intArrayOf(1, 3, 2), nums)
    }

    @Test
    fun `handles pivot with descending suffix`() {
        val nums = intArrayOf(1, 3, 2)
        Solution().nextPermutation(nums)
        assertArrayEquals(intArrayOf(2, 1, 3), nums)
    }

    @Test
    fun `wraps highest permutation to lowest`() {
        val nums = intArrayOf(3, 2, 1)
        Solution().nextPermutation(nums)
        assertArrayEquals(intArrayOf(1, 2, 3), nums)
    }

    @Test
    fun `handles duplicates`() {
        val nums = intArrayOf(1, 1, 5)
        Solution().nextPermutation(nums)
        assertArrayEquals(intArrayOf(1, 5, 1), nums)
    }

    @Test
    fun `handles single element`() {
        val nums = intArrayOf(1)
        Solution().nextPermutation(nums)
        assertArrayEquals(intArrayOf(1), nums)
    }
}
