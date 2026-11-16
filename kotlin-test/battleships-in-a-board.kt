package battleshipsinaboard

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BattleshipsInABoardTest {
    private val solution = Solution()

    @Test
    fun `counts horizontal and vertical ships in standard example`() {
        val board = arrayOf(
            charArrayOf('X', '.', '.', 'X'),
            charArrayOf('.', '.', '.', 'X'),
            charArrayOf('.', '.', '.', 'X')
        )
        assertEquals(2, solution.countBattleships(board))
    }

    @Test
    fun `returns zero for empty board`() {
        assertEquals(0, solution.countBattleships(emptyArray()))
    }

    @Test
    fun `returns zero for board with empty row`() {
        assertEquals(0, solution.countBattleships(arrayOf(charArrayOf())))
    }

    @Test
    fun `does not count cells within a ship more than once`() {
        val board = arrayOf(
            charArrayOf('X', 'X', 'X', '.', 'X'),
            charArrayOf('.', '.', '.', '.', 'X'),
            charArrayOf('X', '.', 'X', '.', '.')
        )
        assertEquals(4, solution.countBattleships(board))
    }
}
