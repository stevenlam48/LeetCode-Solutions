package maximumktosortapermutation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumKToSortAPermutationTest {
    private val solution = Solution()

    @Test
    fun `combines all displaced indices`() {
        assertEquals(0, solution.sortPermutation(intArrayOf(0, 2, 3, 1, 4)))
    }

    @Test
    fun `preserves shared index bits`() {
        assertEquals(2, solution.sortPermutation(intArrayOf(0, 1, 3, 2)))
    }

    @Test
    fun `returns zero for a sorted permutation`() {
        assertEquals(0, solution.sortPermutation(intArrayOf(0, 1, 2, 3)))
    }

    @Test
    fun `returns zero when displaced indices share no bits`() {
        assertEquals(0, solution.sortPermutation(intArrayOf(1, 0, 2)))
    }
}
