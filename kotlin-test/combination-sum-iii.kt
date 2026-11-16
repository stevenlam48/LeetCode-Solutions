package combinationsumiii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CombinationSumIiiTest {
    private val solution = Solution()

    private fun toLists(cells: Array<IntArray>): List<List<Int>> = cells.map { it.toList() }

    @Test
    fun testExample1() {
        assertEquals(listOf(listOf(1, 2, 4)), toLists(solution.combinationSum3(3, 7)))
    }

    @Test
    fun testExample2() {
        assertEquals(
            listOf(listOf(1, 2, 6), listOf(1, 3, 5), listOf(2, 3, 4)),
            toLists(solution.combinationSum3(3, 9))
        )
    }

    @Test
    fun testNoSolution() {
        assertEquals(emptyList<List<Int>>(), toLists(solution.combinationSum3(4, 1)))
        assertEquals(emptyList<List<Int>>(), toLists(solution.combinationSum3(2, 18)))
    }

    @Test
    fun testAllDigits() {
        assertEquals(
            listOf(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)),
            toLists(solution.combinationSum3(9, 45))
        )
    }

    @Test
    fun testSingleNumber() {
        assertEquals(listOf(listOf(5)), toLists(solution.combinationSum3(1, 5)))
    }
}
