package numberofvalidmovecombinationsonchessboard

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfValidMoveCombinationsOnChessboardTest {
    @Test
    fun rook() {
        assertEquals(15, Solution().countCombinations(listOf("rook"), arrayOf(intArrayOf(1, 1))))
    }

    @Test
    fun queen() {
        assertEquals(22, Solution().countCombinations(listOf("queen"), arrayOf(intArrayOf(1, 1))))
    }

    @Test
    fun bishop() {
        assertEquals(12, Solution().countCombinations(listOf("bishop"), arrayOf(intArrayOf(4, 3))))
    }

    @Test
    fun twoRooks() {
        assertEquals(223, Solution().countCombinations(listOf("rook", "rook"), arrayOf(intArrayOf(1, 1), intArrayOf(8, 8))))
    }

    @Test
    fun queenAndBishop() {
        assertEquals(281, Solution().countCombinations(listOf("queen", "bishop"), arrayOf(intArrayOf(5, 7), intArrayOf(3, 4))))
    }
}
