package longestlineofconsecutiveoneinmatrix

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestLineOfConsecutiveOneInMatrixTest {
    @Test
    fun allOnes() {
        val mat = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1)
        )
        assertEquals(3, Solution().longestLine(mat))
    }

    @Test
    fun mainDiagonal() {
        val mat = arrayOf(
            intArrayOf(1, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 1)
        )
        assertEquals(3, Solution().longestLine(mat))
    }

    @Test
    fun antiDiagonal() {
        val mat = arrayOf(
            intArrayOf(0, 0, 1),
            intArrayOf(0, 1, 0),
            intArrayOf(1, 0, 0)
        )
        assertEquals(3, Solution().longestLine(mat))
    }

    @Test
    fun mixedLines() {
        val mat = arrayOf(
            intArrayOf(1, 1, 0, 1),
            intArrayOf(1, 0, 1, 0),
            intArrayOf(0, 1, 0, 1)
        )
        assertEquals(3, Solution().longestLine(mat))
    }

    @Test
    fun noOnes() {
        val mat = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 0)
        )
        assertEquals(0, Solution().longestLine(mat))
    }

    @Test
    fun emptyMatrix() {
        assertEquals(0, Solution().longestLine(emptyArray()))
    }
}
