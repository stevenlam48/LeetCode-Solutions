package reconstructa2rowbinarymatrix

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ReconstructA2RowBinaryMatrixTest {
    private val solution = Solution()

    private fun assertMatrix(expected: Array<IntArray>, actual: Array<IntArray>) {
        assertEquals(expected.size, actual.size)
        for (i in expected.indices) {
            assertArrayEquals(expected[i], actual[i])
        }
    }

    @Test
    fun testExample1() {
        assertMatrix(
            arrayOf(intArrayOf(1, 1, 0), intArrayOf(0, 0, 1)),
            solution.reconstructMatrix(2, 1, intArrayOf(1, 1, 1))
        )
    }

    @Test
    fun testExample2() {
        assertMatrix(
            arrayOf(intArrayOf(1, 1), intArrayOf(1, 1)),
            solution.reconstructMatrix(2, 2, intArrayOf(2, 2))
        )
    }

    @Test
    fun testImpossibleExample1() {
        assertMatrix(
            emptyArray(),
            solution.reconstructMatrix(2, 3, intArrayOf(2, 2, 1, 1))
        )
    }

    @Test
    fun testImpossibleExample2() {
        assertMatrix(
            emptyArray(),
            solution.reconstructMatrix(1, 1, intArrayOf(2, 2))
        )
        assertMatrix(
            emptyArray(),
            solution.reconstructMatrix(0, 0, intArrayOf(1))
        )
    }

    @Test
    fun testAllZero() {
        assertMatrix(
            arrayOf(intArrayOf(0, 0), intArrayOf(0, 0)),
            solution.reconstructMatrix(0, 0, intArrayOf(0, 0))
        )
    }

    @Test
    fun testAllTwo() {
        assertMatrix(
            arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 1)),
            solution.reconstructMatrix(3, 3, intArrayOf(2, 2, 2))
        )
    }
}
