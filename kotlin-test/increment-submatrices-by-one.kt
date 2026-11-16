package incrementsubmatricesbyone

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class IncrementSubmatricesByOneTest {
    private fun assertMatrix(expected: Array<IntArray>, actual: Array<IntArray>) {
        for (i in expected.indices) {
            assertArrayEquals(expected[i], actual[i])
        }
    }

    @Test
    fun example() {
        val queries = arrayOf(
            intArrayOf(1, 1, 2, 2),
            intArrayOf(0, 0, 1, 1)
        )
        val expected = arrayOf(
            intArrayOf(1, 1, 0),
            intArrayOf(1, 2, 1),
            intArrayOf(0, 1, 1)
        )
        assertMatrix(expected, Solution().rangeAddQueries(3, queries))
    }

    @Test
    fun fullMatrix() {
        val expected = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 1)
        )
        assertMatrix(expected, Solution().rangeAddQueries(2, arrayOf(intArrayOf(0, 0, 1, 1))))
    }

    @Test
    fun singleCell() {
        assertMatrix(
            arrayOf(intArrayOf(1)),
            Solution().rangeAddQueries(1, arrayOf(intArrayOf(0, 0, 0, 0)))
        )
    }

    @Test
    fun noQueries() {
        val expected = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 0)
        )
        assertMatrix(expected, Solution().rangeAddQueries(2, emptyArray()))
    }
}
