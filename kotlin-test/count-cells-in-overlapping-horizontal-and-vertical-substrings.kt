package countcellsinoverlappinghorizontalandverticalsubstrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountCellsInOverlappingHorizontalAndVerticalSubstringsTest {
    @Test
    fun singleCell() {
        assertEquals(1, Solution().countCells(arrayOf(charArrayOf('a')), "a"))
        assertEquals(0, Solution().countCells(arrayOf(charArrayOf('a')), "b"))
    }

    @Test
    fun symmetricMatches() {
        assertEquals(2, Solution().countCells(arrayOf(charArrayOf('a', 'b'), charArrayOf('c', 'a')), "a"))
    }

    @Test
    fun allCellsOverlap() {
        assertEquals(4, Solution().countCells(arrayOf(charArrayOf('a', 'a'), charArrayOf('a', 'a')), "aa"))
    }

    @Test
    fun horizontalMatchWithoutVerticalMatch() {
        assertEquals(0, Solution().countCells(arrayOf(charArrayOf('a', 'b'), charArrayOf('c', 'a')), "ab"))
    }
}
