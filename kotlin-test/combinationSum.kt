package combinationSum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CombinationSumTest {
    private val solution = Solution()

    private fun toLists(cells: Array<IntArray>): List<List<Int>> = cells.map { it.toList() }

    @Test
    fun testExample1() {
        assertEquals(
            listOf(listOf(2, 2, 3), listOf(7)),
            toLists(solution.combinationSum(intArrayOf(2, 3, 6, 7), 7))
        )
    }

    @Test
    fun testExample2() {
        assertEquals(
            listOf(listOf(2, 2, 2, 2), listOf(2, 3, 3), listOf(3, 5)),
            toLists(solution.combinationSum(intArrayOf(2, 3, 5), 8))
        )
    }

    @Test
    fun testNoSolution() {
        assertEquals(emptyList<List<Int>>(), toLists(solution.combinationSum(intArrayOf(2), 1)))
    }

    @Test
    fun testSingleCandidate() {
        assertEquals(
            listOf(listOf(3, 3)),
            toLists(solution.combinationSum(intArrayOf(3), 6))
        )
    }

    @Test
    fun testUnsortedCandidates() {
        assertEquals(
            listOf(listOf(2, 2, 3), listOf(7)),
            toLists(solution.combinationSum(intArrayOf(7, 2, 3, 6), 7))
        )
    }
}
