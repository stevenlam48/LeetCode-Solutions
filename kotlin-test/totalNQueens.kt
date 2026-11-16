package totalNQueens

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TotalNQueensTest {
    @Test
    fun oneQueen() {
        assertEquals(1, Solution().totalNQueens(1))
    }

    @Test
    fun twoQueens() {
        assertEquals(0, Solution().totalNQueens(2))
    }

    @Test
    fun threeQueens() {
        assertEquals(0, Solution().totalNQueens(3))
    }

    @Test
    fun fourQueens() {
        assertEquals(2, Solution().totalNQueens(4))
    }

    @Test
    fun eightQueens() {
        assertEquals(92, Solution().totalNQueens(8))
    }
}
