package designtictactoe

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DesignTicTacToeTest {
    @Test
    fun testExample() {
        val game = TicTacToe(3)
        assertEquals(0, game.move(0, 0, 1))
        assertEquals(0, game.move(0, 1, 2))
        assertEquals(0, game.move(1, 1, 1))
        assertEquals(0, game.move(0, 2, 2))
        assertEquals(1, game.move(2, 2, 1))
    }

    @Test
    fun testRowWin() {
        val game = TicTacToe(3)
        assertEquals(0, game.move(0, 0, 1))
        assertEquals(0, game.move(1, 0, 2))
        assertEquals(0, game.move(0, 1, 1))
        assertEquals(0, game.move(1, 1, 2))
        assertEquals(1, game.move(0, 2, 1))
    }

    @Test
    fun testColumnWin() {
        val game = TicTacToe(3)
        assertEquals(0, game.move(0, 2, 1))
        assertEquals(0, game.move(0, 0, 2))
        assertEquals(0, game.move(1, 2, 1))
        assertEquals(0, game.move(1, 0, 2))
        assertEquals(1, game.move(2, 2, 1))
    }

    @Test
    fun testAntiDiagonalWin() {
        val game = TicTacToe(3)
        assertEquals(0, game.move(0, 2, 1))
        assertEquals(0, game.move(0, 0, 2))
        assertEquals(0, game.move(1, 1, 1))
        assertEquals(0, game.move(0, 1, 2))
        assertEquals(1, game.move(2, 0, 1))
    }

    @Test
    fun testSingleCellBoard() {
        assertEquals(1, TicTacToe(1).move(0, 0, 1))
    }

    @Test
    fun testNoWinner() {
        val game = TicTacToe(3)
        assertEquals(0, game.move(0, 0, 1))
        assertEquals(0, game.move(0, 1, 2))
        assertEquals(0, game.move(0, 2, 1))
        assertEquals(0, game.move(1, 2, 2))
        assertEquals(0, game.move(1, 0, 1))
        assertEquals(0, game.move(2, 0, 2))
        assertEquals(0, game.move(1, 1, 1))
        assertEquals(0, game.move(2, 2, 2))
        assertEquals(0, game.move(2, 1, 1))
    }
}
