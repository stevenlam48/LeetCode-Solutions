package minimizemaximumvalueinagrid

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimizeMaximumValueInAGridTest {
    @Test
    fun standardGrid() {
        val grid = arrayOf(
            intArrayOf(1, 7, 3),
            intArrayOf(9, 8, 2),
            intArrayOf(4, 5, 6)
        )
        assertGrid(
            arrayOf(
                intArrayOf(1, 4, 2),
                intArrayOf(6, 5, 1),
                intArrayOf(2, 3, 4)
            ),
            Solution().minScore(grid)
        )
    }

    @Test
    fun singleCell() {
        assertGrid(arrayOf(intArrayOf(1)), Solution().minScore(arrayOf(intArrayOf(42))))
    }

    @Test
    fun duplicateValuesInOneRow() {
        assertGrid(
            arrayOf(intArrayOf(1, 2, 3)),
            Solution().minScore(arrayOf(intArrayOf(2, 2, 2)))
        )
    }

    @Test
    fun rectangularGrid() {
        val grid = arrayOf(intArrayOf(4, 1, 3), intArrayOf(2, 6, 5))
        assertGrid(
            arrayOf(intArrayOf(3, 1, 2), intArrayOf(1, 4, 3)),
            Solution().minScore(grid)
        )
    }
}

private fun assertGrid(expected: Array<IntArray>, actual: Array<IntArray>) {
    assertEquals(expected.size, actual.size)
    for (i in expected.indices) {
        assertArrayEquals(expected[i], actual[i])
    }
}
