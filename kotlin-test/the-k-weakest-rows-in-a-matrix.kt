package thekweakestrowsinamatrix

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class TheKWeakestRowsInAMatrixTest {

    @Test
    fun testExample1() {
        val mat = arrayOf(
            intArrayOf(1, 1, 0, 0, 0),
            intArrayOf(1, 1, 1, 1, 0),
            intArrayOf(1, 0, 0, 0, 0),
            intArrayOf(1, 1, 0, 0, 0),
            intArrayOf(1, 1, 1, 1, 1)
        )
        assertArrayEquals(intArrayOf(2, 0, 3), Solution().kWeakestRows(mat, 3))
    }

    @Test
    fun testExample2() {
        val mat = arrayOf(
            intArrayOf(1, 0, 0, 0),
            intArrayOf(1, 1, 1, 1),
            intArrayOf(1, 0, 0, 0),
            intArrayOf(1, 0, 0, 0)
        )
        assertArrayEquals(intArrayOf(0, 2), Solution().kWeakestRows(mat, 2))
    }

    @Test
    fun testAllRowsAreEqual() {
        val mat = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 1),
            intArrayOf(1, 1)
        )
        assertArrayEquals(intArrayOf(0, 1), Solution().kWeakestRows(mat, 2))
    }

    @Test
    fun testAllZeroRows() {
        val mat = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 0),
            intArrayOf(0, 0)
        )
        assertArrayEquals(intArrayOf(0, 1, 2), Solution().kWeakestRows(mat, 3))
    }

    @Test
    fun testKEqualsRows() {
        val mat = arrayOf(
            intArrayOf(1, 1, 0),
            intArrayOf(1, 0, 0),
            intArrayOf(1, 1, 1)
        )
        assertArrayEquals(intArrayOf(1, 0, 2), Solution().kWeakestRows(mat, 3))
    }
}
