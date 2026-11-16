package rowwithmaximumones

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class RowWithMaximumOnesTest {
    @Test
    fun leetCodeExampleTiePicksFirstRow() {
        val mat = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0)
        )
        assertArrayEquals(intArrayOf(0, 1), Solution().rowAndMaximumOnes(mat))
    }

    @Test
    fun leetCodeExampleSecondRowWins() {
        val mat = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(1, 1),
            intArrayOf(0, 0)
        )
        assertArrayEquals(intArrayOf(1, 2), Solution().rowAndMaximumOnes(mat))
    }

    @Test
    fun singleZeroCell() {
        val mat = arrayOf(intArrayOf(0))
        assertArrayEquals(intArrayOf(0, 0), Solution().rowAndMaximumOnes(mat))
    }

    @Test
    fun lastRowHasMostOnes() {
        val mat = arrayOf(
            intArrayOf(1, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(1, 1, 1)
        )
        assertArrayEquals(intArrayOf(2, 3), Solution().rowAndMaximumOnes(mat))
    }
}
