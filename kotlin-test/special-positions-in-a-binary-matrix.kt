package specialpositionsinabinarymatrix

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SpecialPositionsInABinaryMatrixTest {
    @Test
    fun exampleOne() {
        val mat = arrayOf(
            intArrayOf(1, 0, 0),
            intArrayOf(0, 0, 1),
            intArrayOf(1, 0, 0)
        )
        assertEquals(1, Solution().numSpecial(mat))
    }

    @Test
    fun identityMatrix() {
        val mat = arrayOf(
            intArrayOf(1, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 1)
        )
        assertEquals(3, Solution().numSpecial(mat))
    }

    @Test
    fun allZeros() {
        val mat = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0)
        )
        assertEquals(0, Solution().numSpecial(mat))
    }

    @Test
    fun singleCell() {
        assertEquals(1, Solution().numSpecial(arrayOf(intArrayOf(1))))
        assertEquals(0, Solution().numSpecial(arrayOf(intArrayOf(0))))
    }
}
