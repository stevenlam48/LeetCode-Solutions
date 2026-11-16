package queensthatcanattacktheking

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class QueensThatCanAttackTheKingTest {
    private val solution = Solution()

    private fun toList(a: Array<IntArray>): List<List<Int>> = a.map { it.toList() }

    @Test
    fun testExample1() {
        val queens = arrayOf(
            intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(4, 0),
            intArrayOf(0, 4), intArrayOf(3, 3), intArrayOf(2, 4)
        )
        val expected = listOf(listOf(0, 1), listOf(1, 0), listOf(3, 3))
        assertEquals(expected, toList(solution.queensAttacktheKing(queens, intArrayOf(0, 0))))
    }

    @Test
    fun testExample2() {
        val queens = arrayOf(
            intArrayOf(0, 0), intArrayOf(1, 1), intArrayOf(2, 2),
            intArrayOf(3, 4), intArrayOf(3, 5), intArrayOf(4, 4), intArrayOf(4, 5)
        )
        val expected = listOf(listOf(3, 4), listOf(4, 4), listOf(2, 2))
        assertEquals(expected, toList(solution.queensAttacktheKing(queens, intArrayOf(3, 3))))
    }

    @Test
    fun testNoQueens() {
        assertEquals(emptyList<List<Int>>(), toList(solution.queensAttacktheKing(arrayOf(), intArrayOf(0, 0))))
    }

    @Test
    fun testNearestOnly() {
        val queens = arrayOf(intArrayOf(0, 0), intArrayOf(1, 1), intArrayOf(2, 2))
        val expected = listOf(listOf(2, 2), listOf(0, 0), listOf(1, 1))
        assertEquals(expected, toList(solution.queensAttacktheKing(queens, intArrayOf(0, 2))))
    }
}
