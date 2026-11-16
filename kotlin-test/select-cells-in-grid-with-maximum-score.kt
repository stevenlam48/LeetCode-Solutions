package selectcellsingridwithmaximumscore

// Time:  O(n^2 * max(n, r)), r = max(x for row in grid for x in row)
// Space: O(n * max(n, r))

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SelectCellsInGridWithMaximumScoreTest {
    @Test
    fun firstExample() {
        val grid = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 3, 2), intArrayOf(1, 1, 1))
        assertEquals(8, Solution().maxScore(grid))
    }

    @Test
    fun secondExample() {
        val grid = arrayOf(intArrayOf(8, 7, 6), intArrayOf(8, 3, 2))
        assertEquals(15, Solution().maxScore(grid))
    }

    @Test
    fun singleCell() {
        assertEquals(5, Solution().maxScore(arrayOf(intArrayOf(5))))
    }

    @Test
    fun duplicateValues() {
        val grid = arrayOf(intArrayOf(4, 4, 1), intArrayOf(2, 3, 3))
        assertEquals(7, Solution().maxScore(grid))
    }

    @Test
    fun emptyGrid() {
        assertEquals(0, Solution().maxScore(emptyArray()))
    }
}
