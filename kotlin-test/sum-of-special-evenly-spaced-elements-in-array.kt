package sumofspecialevenlyspacedelementsinarray

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SumOfSpecialEvenlySpacedElementsInArrayTest {
    private val solution = Solution()

    @Test
    fun directLargeStrideQueries() {
        val queries = arrayOf(intArrayOf(0, 2), intArrayOf(1, 2))
        assertArrayEquals(intArrayOf(9, 6), solution.solve(intArrayOf(1, 2, 3, 4, 5), queries))
    }

    @Test
    fun cachedPrefixQueries() {
        val queries = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 1),
            intArrayOf(2, 1),
            intArrayOf(0, 2),
            intArrayOf(2, 2)
        )
        assertArrayEquals(
            intArrayOf(21, 20, 18, 9, 8),
            solution.solve(intArrayOf(1, 2, 3, 4, 5, 6), queries)
        )
    }

    @Test
    fun differentResiduesForSameStride() {
        val queries = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(0, 2),
            intArrayOf(3, 2),
            intArrayOf(5, 2)
        )
        assertArrayEquals(
            intArrayOf(12, 9, 10, 6),
            solution.solve(intArrayOf(1, 2, 3, 4, 5, 6), queries)
        )
    }

    @Test
    fun sumsAreReducedModulo() {
        val queries = arrayOf(intArrayOf(0, 1))
        val nums = intArrayOf(1_000_000_000, 1_000_000_000, 1_000_000_000)
        assertArrayEquals(intArrayOf(999_999_986), solution.solve(nums, queries))
    }

    @Test
    fun emptyQueries() {
        assertArrayEquals(intArrayOf(), solution.solve(intArrayOf(1, 2, 3), emptyArray()))
    }
}
