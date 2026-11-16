package equalrowandcolumnpairs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EqualRowAndColumnPairsTest {
    private val solution = Solution()

    @Test
    fun firstLeetCodeExample() {
        val grid = arrayOf(
            intArrayOf(3, 2, 1),
            intArrayOf(1, 7, 6),
            intArrayOf(2, 7, 7)
        )
        assertEquals(1, solution.equalPairs(grid))
    }

    @Test
    fun secondLeetCodeExample() {
        val grid = arrayOf(
            intArrayOf(3, 1, 2, 2),
            intArrayOf(1, 4, 4, 5),
            intArrayOf(2, 4, 2, 2),
            intArrayOf(2, 4, 2, 2)
        )
        assertEquals(3, solution.equalPairs(grid))
    }

    @Test
    fun singleElementAlwaysMatches() {
        assertEquals(1, solution.equalPairs(arrayOf(intArrayOf(7))))
    }

    @Test
    fun duplicateRowsAndColumnsMultiplyCounts() {
        val grid = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 1)
        )
        assertEquals(4, solution.equalPairs(grid))
    }

    @Test
    fun noMatchingPairs() {
        val grid = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4)
        )
        assertEquals(0, solution.equalPairs(grid))
    }
}
