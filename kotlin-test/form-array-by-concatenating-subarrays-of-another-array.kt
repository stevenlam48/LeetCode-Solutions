package formarraybyconcatenatingsubarraysofanotherarray

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class FormArrayByConcatenatingSubarraysOfAnotherArrayTest {
    private val solution = Solution()

    @Test
    fun `groups appear in order with separated subarrays`() {
        val groups = arrayOf(intArrayOf(1, -1, -1), intArrayOf(3, -2, 0))
        val nums = intArrayOf(1, -1, 0, 1, -1, -1, 3, -2, 0)

        assertTrue(solution.canChoose(groups, nums))
    }

    @Test
    fun `group before the previous group is not allowed`() {
        val groups = arrayOf(intArrayOf(10, -2), intArrayOf(1, -1))
        val nums = intArrayOf(1, 2, 3, 4, 10, -2)

        assertFalse(solution.canChoose(groups, nums))
    }

    @Test
    fun `later group cannot overlap previous match`() {
        val groups = arrayOf(intArrayOf(1, 2, 3), intArrayOf(3, 4))
        val nums = intArrayOf(7, 7, 1, 2, 3, 4, 7, 7)

        assertFalse(solution.canChoose(groups, nums))
    }

    @Test
    fun `adjacent disjoint groups are accepted`() {
        val groups = arrayOf(intArrayOf(1, 2), intArrayOf(3), intArrayOf(4, 5))
        val nums = intArrayOf(0, 1, 2, 3, 4, 5, 6)

        assertTrue(solution.canChoose(groups, nums))
    }

    @Test
    fun `repeated values require kmp prefix fallback`() {
        val groups = arrayOf(intArrayOf(1, 1, 2), intArrayOf(1, 1))
        val nums = intArrayOf(1, 1, 1, 2, 1, 1)

        assertTrue(solution.canChoose(groups, nums))
    }

    @Test
    fun `same elements cannot be reused by two groups`() {
        val groups = arrayOf(intArrayOf(1, 1), intArrayOf(1, 1))
        val nums = intArrayOf(1, 1, 1)

        assertFalse(solution.canChoose(groups, nums))
    }
}
