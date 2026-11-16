package combinationSum2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CombinationSum2Test {
    private val solution = Solution()

    private fun toLists(cells: Array<IntArray>): List<List<Int>> = cells.map { it.toList() }

    @Test
    fun testExample1() {
        assertEquals(
            listOf(listOf(1, 1, 6), listOf(1, 2, 5), listOf(1, 7), listOf(2, 6)),
            toLists(solution.combinationSum2(intArrayOf(10, 1, 2, 7, 6, 1, 5), 8))
        )
    }

    @Test
    fun testExample2() {
        assertEquals(
            listOf(listOf(1, 2, 2), listOf(5)),
            toLists(solution.combinationSum2(intArrayOf(2, 5, 2, 1, 2), 5))
        )
    }

    @Test
    fun testNoSolution() {
        assertEquals(emptyList<List<Int>>(), toLists(solution.combinationSum2(intArrayOf(3, 4), 2)))
    }

    @Test
    fun testDuplicatesUsedOnce() {
        assertEquals(
            listOf(listOf(1, 1)),
            toLists(solution.combinationSum2(intArrayOf(1, 1), 2))
        )
    }

    @Test
    fun testSingleElement() {
        assertEquals(
            listOf(listOf(5)),
            toLists(solution.combinationSum2(intArrayOf(5), 5))
        )
    }
}
